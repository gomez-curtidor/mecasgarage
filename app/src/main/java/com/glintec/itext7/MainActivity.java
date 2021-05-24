package com.glintec.itext7;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.RelativeDateTimeFormatter;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.GrooveBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

/*
    String[] arr_carType={
            "SEDAN","HATCHBACK","FAMILIAR","COUPÉ","CABRIOLET","CROSSOVER","MONOVOLUMEN",
            "PICK-UP","UTILITARIO","DEPORTIVO"};

    String[] arr_marca={
            "FORD","NISSAN","CHEVROLET","DODGE","GMC","RENAULT","HONDA","TOYOTA","PEUGEOT",
            "VOLKSWAGEN","FIAT","SEAT","AUDI","ALFA ROMEO"};

    String[] arr_cilindrada={
            "1.0","1.1", "1.2", "1.3" ,"1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1",
            "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3.0", "3.1", "3.2", "3.3",
            "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0", "4.1", "4.2", "4.3", "4.4", "4.5",
            "4.6", "4.7", "4.8", "4.9", "5.0", "5.1", "5.2", "5.3", "5.4", "5.5", "5.6", "5.7",
            "5.8", "5.9", "6.0"};

    String[] arr_transmision={
            "MANUAL", "AUTOMATICA", "TRIPTRONIC"};

    String[] arr_direccion={
            "MECÁNICA", "HIDRÁULICA", "ELECTROHIDRÁULICA", "ELECTRÓNICA"};

    String[] arr_traccion={
            "DELANTERA", "TRACERA", "INTEGRAL"};

    String[] arr_trenValvulas={
            "OHV", "SOHC", "DOHC"};

    String[] arr_distribucion={
            "INDIRECTA", "XXX", "XXX"};

    String[] arr_comunicacion={
            "OBD II RED CAN BUS", "XXX", "XXX"};
*/
//----------------------------------------------
/*
            String[] sintoma={
                    " ", "Menos de 1 semana", "1 semana", "2 semanas",
                    "3 semanas", "1 mes", "1 mes y 1 semana",
                    "1 mes y 2 semanas", "1 mes y 3 semanas", "2 meses o más",
                    "Desconoce" };
            String[] servMesPasado ={"Si","No"};
            String[] tipoServicio={"Diagnóstico", "Mantenimiento", "Reparación",
                    "Desconoce", "Ninguno"};
            String[] problemaEncender={"Enciende sin problema", "Sin marcha", "Marcha, pero no prende",
                    "Prende, pero tarda"};
            String[] motorDetiene={"Después de encender", "En marcha", "En conducción", "En semáforos o topes",
                    "En ralentí", "Acelerándolo", "Al estacionarse"};
            String[] ralenti={
                    "Demasiado lento", "Demasiado rápido", "Intermitente",
                    "Áspero o desigual", "Fluctuante", "Otros"};

            String[] condFuncionamiento={
                    "Áspero", "Pierde potencia", "Jaloneos o tironeos", "Consumo de combustible",
                    "Vacila al acelerar", "Pre ignición/Detonación", "Fallas de encendido",
                    "Golpes o ruidos de motor", "Calentamiento", "Otros"};

            String[] probTransmicion={
                    "Ninguno",
                    "Cambios incorrectos 1",
                    "Cambios incorrectos 2",
                    "Sin cambios/avance",
                    "Jaloneos o tironeos",
                    "Otros"};
            String[] ocurreFalla={
                    "Mañana",
                    "Tarde",
                    "Noche",
                    "En cualquier momento"};
            String[] tempMotor={
                    "Frio",
                    "Al calentarse",
                    "Caliente"};
            String[] condicionManejoFalla={
                    "Al realizar cambios",
                    "Con A/C operando",
                    "Con los faros encendidos",
                    "Al acelerar",
                    "Al desacelerar",
                    "En bajadas",
                    "En subidas",
                    "Nivelado",
                    "En curvas",
                    "Superficies irregulares",
                    "Otros"};
            String[] habitosManejo={
                    "En ciudad",
                    "En autopista",
                    "En suburbios",
                    "En terracería"};
            String[] combustible={
                    "Magna",
                    "Premium",
                    "Etanol",
                    "Diesel",
                    "Biodiesel",
                    "E85",
                    "Metanol",
                    "Propano",
                    "Otros"};
            String[]  olor={
                    "Aceite quemado",
                    "Caliente",
                    "Combustible",
                    "Cables quemados",
                    "Dulce",
                    "Ninguno",
                    "Otros"};
            String[] ruido={
                    "Ninguno",
                    "Cliqueo" ,
                    "Chasquido" ,
                    "Golpeteo" ,
                    "Traqueteo" ,
                    "Estruendos" ,
                    "Quejido" ,
                    "Vibración" ,
                    "Siseo" ,
                    "Chillido",
                    "Trancazo" ,
                    "Otros"};
            String[] kmSintoma={
                    "1 a 5 km",
                    "5 a 15 km",
                    "15 a 25 km",
                    "Mayor0 a 25 km"};
            String[] kmDia={
                    "1 a 5 km",
                    "5 a 10 km",
                    "10 a 15 km",
                    "15 a 20 km",
                    "20 a 25 km",
                    "25 a 30 km",
                    "30 a 35 km",
                    "35 a 40 km",
                    "40 a 45 km",
                    "45 a 50 km",
                    "Mas de 50 km"};
            String[] indicadorMalFuncionamiento={
                    "Si, siempre",
                    "Si, algunas veces",
                    "Si, parpadea",
                    "No",
                    "No, nunca prende"};*/

    private Spinner sp_Sintoma, sp_servMesPasado, sp_tipoServicio, sp_problemaEncender,
            sp_ralenti, sp_motorDetiene, sp_condFuncionamiento, sp_probTransmicion,
            sp_ocurreFalla, sp_tempMotor, sp_condicionManejoFalla, sp_habitosManejo,
            sp_combustible, sp_olor, sp_ruido, sp_kmSintoma, sp_kmDia, sp_indicadorMalFuncionamiento;
//----------------------------------------------

    private EditText edName, edOrden, edPhone, edMail, edPlates, edColorCar, edVIN, edKm, edEngine,
            edSubmarca, edModelo, edNoValv,  edMSintoma, edMProblema, edAge, edLocation;
    private Spinner spTypeCar, spMarca, spCilindrada, spTransmision, spTraccion, spDireccion,
                    spTrenValv, spDistribucion, spComunicacion;
    private Button btnAcept;
    private TextView tV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName=findViewById(R.id.EdT_Name);  //Nombre
        edOrden = findViewById(R.id.EdT_Orden);  //No de orden
        edPhone = findViewById(R.id.EdT_Phone); //Telefono
        edMail = findViewById(R.id.EdT_email);  //email
        edPlates = findViewById(R.id.EdT_Plates);  //Placas
        edColorCar = findViewById(R.id.EdT_ColorCar);  //Color de carro
        edVIN = findViewById(R.id.EdT_VIN);  //VIN
        edKm = findViewById(R.id.EdT_Kilometraje);  //Kilometraje
        edEngine = findViewById(R.id.EdT_Engine);  //Motor
        edSubmarca = findViewById(R.id.edT_Submarca);  //Submarca
        edModelo = findViewById(R.id.EdT_Modelo);  //Modelo
        edNoValv = findViewById(R.id.EdT_NoValv);  //# Valvulas
        edMSintoma = findViewById(R.id.edTM_Sintoma);  //Descripcion Sintoma
        edMProblema = findViewById(R.id.edTM_VerProblema); //Verificar  Problema

        tV1=findViewById(R.id.textView1);

        btnAcept = findViewById(R.id.btn_ACEPT);

        edAge = findViewById(R.id.EdT_Orden);
        edLocation = findViewById(R.id.EdT_email);

        spTypeCar = findViewById(R.id.spin_TypeCar);
//        defineSpinner(arr_carType,spTypeCar);

        spMarca = findViewById(R.id.spin_MarcaCar);
//        defineSpinner(arr_marca,spMarca);

        spCilindrada = findViewById(R.id.spin_Cilindrada);
//        defineSpinner(arr_cilindrada,spCilindrada);

        spTransmision = findViewById(R.id.spin_Transmision);
//        defineSpinner(arr_transmision,spTransmision);

        spTraccion = findViewById(R.id.spin_Traccion);
//        defineSpinner(arr_traccion,spTraccion);

        spDireccion = findViewById(R.id.spin_Direccion);
//        defineSpinner(arr_direccion,spDireccion);

        spTrenValv = findViewById(R.id.spin_trenValv);
//        defineSpinner(arr_trenValvulas,spTrenValv);

        spDistribucion = findViewById(R.id.spin_Distribucion);
//        defineSpinner(arr_distribucion,spDistribucion);

        edNoValv = findViewById(R.id.EdT_NoValv);

        spComunicacion = findViewById(R.id.spin_Comunicacion);
//        defineSpinner(arr_comunicacion,spComunicacion);

        sp_Sintoma= findViewById(R.id.spin_Sintoma);
//        defineSpinner(sintoma,sp_Sintoma);

        sp_servMesPasado =findViewById(R.id.spin_servMesPasado);
//        defineSpinner(servMesPasado,sp_servMesPasado);

        sp_tipoServicio = findViewById(R.id.spin_tipoServicio);
//        defineSpinner(tipoServicio,sp_tipoServicio);

        sp_problemaEncender = findViewById(R.id.spin_problemaEncender);
//        defineSpinner(problemaEncender,sp_problemaEncender);

        sp_ralenti = findViewById(R.id.spin_ralenti);
//        defineSpinner(ralenti,sp_ralenti);

        sp_motorDetiene = findViewById(R.id.spin_motorDetiene);
//        defineSpinner(motorDetiene,sp_motorDetiene);

        sp_condFuncionamiento = findViewById(R.id.spin_condFuncionamiento);
//        defineSpinner(condFuncionamiento,sp_condFuncionamiento);

        sp_probTransmicion = findViewById(R.id.spin_probTransmicion);
//        defineSpinner(probTransmicion,sp_probTransmicion);

        sp_ocurreFalla = findViewById(R.id.spin_ocurreFalla);
//        defineSpinner(ocurreFalla,sp_ocurreFalla);

        sp_tempMotor = findViewById(R.id.spin_tempMotor);
//        defineSpinner(tempMotor,sp_tempMotor);

        sp_condicionManejoFalla= findViewById(R.id.spin_condicionManejoFalla);
//        defineSpinner(condicionManejoFalla,sp_condicionManejoFalla);

        sp_habitosManejo= findViewById(R.id.spin_habitosManejo);
//        defineSpinner(habitosManejo,sp_habitosManejo);

        sp_combustible = findViewById(R.id.spin_combustible);
//        defineSpinner(combustible,sp_combustible);

        sp_olor = findViewById(R.id.spin_olor);
//        defineSpinner(olor,sp_olor);

        sp_ruido = findViewById(R.id.spin_Ruido);
//        defineSpinner(ruido,sp_ruido);

        sp_kmSintoma = findViewById(R.id.spin_kmSintoma);
//        defineSpinner(kmSintoma,sp_kmSintoma);

        sp_kmDia = findViewById(R.id.spin_kmDia);
//        defineSpinner(kmDia,sp_kmDia);

        sp_indicadorMalFuncionamiento = findViewById(R.id.spin_indicadorMalFuncionamiento);
//        defineSpinner(indicadorMalFuncionamiento,sp_indicadorMalFuncionamiento);


//        btnAcept.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.O)
//            @Override
//            public void onClick(View v) {
//                String name = edName.getText().toString();
//                String age = edAge.getText().toString();
//                String locacion = edLocation.getText().toString();
//
//                try {
//                    createPDFButton(name, age, locacion);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

//        try {
//            createPDF();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }



        btnAcept.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                try {

                        createPlantilla();

//                    createPDF();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });



    }



    public void verificacionTexto(Spinner checkSpiner, TextView tvCambiarColor){
        if (checkSpiner.isPressed()){
//            checkSpiner.setForeground(Color.ORANGE);
            tvCambiarColor.setTextColor(android.graphics.Color.GREEN);
//            Toast.makeText(this,"Seleccionado spinner",Toast.LENGTH_LONG).show();
        }

    }

    private void defineSpinner (String[] NameArrayAdapter, Spinner nameSpinner) {
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, NameArrayAdapter);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item_mecas, NameArrayAdapter);
        nameSpinner.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void createPlantilla()throws FileNotFoundException{
        String rutaPDF = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File archivo = new File(rutaPDF, "MECAS_3.pdf");

//        File rutaPDF = Environment.getExternalStorageDirectory();
//        File archivo = new File(rutaPDF.getPath(), "MECAS_3.pdf");


        FileOutputStream outStream = new FileOutputStream(archivo);

        PdfWriter escritor = new PdfWriter(archivo);
        PdfDocument documentPDF = new PdfDocument(escritor);
        Document doc = new Document(documentPDF);

        documentPDF.setDefaultPageSize(PageSize.LETTER);  //tamanho de pagina
        doc.setMargins(20, 20, 20, 20); //margenes de

        Drawable dr = getDrawable(R.drawable.mecaslogo);
        Bitmap mapBit = ((BitmapDrawable) dr).getBitmap();
        ByteArrayOutputStream strm = new ByteArrayOutputStream();
        mapBit.compress(Bitmap.CompressFormat.PNG, 100, strm);
        byte[] dataBitmap = strm.toByteArray();
        ImageData dataImage = ImageDataFactory.create(dataBitmap);
        Image img = new Image(dataImage);
        img.setWidth(110);
        img.setHeight(110);
        img.setAutoScaleHeight(false);

//        Paragraph ingreso = new Paragraph("Ingreso").setBold().setFontSize(24).setTextAlignment(TextAlignment.CENTER);
//        Paragraph par1 =  new Paragraph("INGRESANDO \n MECAS garage").setTextAlignment(TextAlignment.CENTER);
//        Paragraph par2 = new Paragraph("GLINTEC").setTextAlignment(TextAlignment.CENTER);

        int num=100;
        float colwidth[]={num, num, num, num, num, num, num, num, num, num, num};
        Table tabla3 = new Table(colwidth);
//        Table tabla3 = new Table(new float[28]).useAllAvailableWidth();
        tabla3.setHorizontalAlignment(HorizontalAlignment.CENTER);

        //renglon 1
        tabla3.addCell(new Cell(8,3).add(new Paragraph("").add(img))
                .setTextAlignment(TextAlignment.CENTER));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 2
        Text str_EspeEfec = new Text("ESPECIALIDAD Y EFECTIVIDAD EN MECÁNICA AUTOMOTRIZ");
        str_EspeEfec.setFontSize(8).setBold().setFontColor(new DeviceRgb(0,112,192));
        Paragraph parEspeEfec = new Paragraph();
        parEspeEfec.add(str_EspeEfec);
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,7).add(parEspeEfec).setTextAlignment(TextAlignment.CENTER));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 3
        Text str_HojaSer = new Text("HOJA DE SERVICIO DE DIAGNÓSTICO Y REPARACIÓN");
        str_HojaSer.setFontSize(12).setBold().setFontColor(new DeviceRgb(0,112,192));
        Paragraph par_HojaSer = new Paragraph();
        par_HojaSer.add(str_HojaSer);
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,7).add(par_HojaSer).setTextAlignment(TextAlignment.CENTER));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 4
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 5
//        String NOMBRE = edName.getText().toString();
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("NOMBRE").setFontSize(9).setBold()
                .setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell(1,4).add(new Paragraph(edName.getText().toString())
                .setFontSize(10).setTextAlignment(TextAlignment.CENTER)));  //input Nombre
//        tabla3.addCell(new Cell().add(new Paragraph("")));
            //        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("ORDEN DE TRABAJO").setBold()
                .setFontSize(9).setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));

        tabla3.addCell(new Cell().add(new Paragraph(edOrden.getText().toString()).setFontSize(10)
                .setTextAlignment(TextAlignment.CENTER))); //input Orden
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 6
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("TELEFONO").setFontSize(9).setBold()
                .setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("5512523684")
                .setFontSize(10).setTextAlignment(TextAlignment.CENTER)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("PLACAS").setBold()
                .setFontSize(9).setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("DFC005").setFontSize(10)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 7
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("E-MAIL").setFontSize(9).setBold()
                .setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("asdd@mecas.com")
                .setFontSize(10).setTextAlignment(TextAlignment.CENTER)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("COLOR").setBold()
                .setFontSize(9).setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("NEGRO").setFontSize(10)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 8
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("FECHA INGRESO").setFontSize(9).setBold()
                .setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("XX/XX/XXXX")
                .setFontSize(10).setTextAlignment(TextAlignment.CENTER)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("FECHA SALIDA").setBold()
                .setFontSize(9).setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("XX/XX/XXXX").setFontSize(10)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 9 en blanco
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 10
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("TIPO").setBold().setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph(spTypeCar.getSelectedItem().toString()).setFontSize(9)).setTextAlignment(TextAlignment.CENTER));//input Tipo
        tabla3.addCell(new Cell().add(new Paragraph("VIN").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("1FAHP3E21CL218418").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("TRANSMISIóN").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("MANUAL").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("TREN VALVULA").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("DOHC").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 11
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("MARCA").setFontSize(9).setBold()
                .setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("FOCUS").setFontSize(9)).setTextAlignment(TextAlignment.CENTER));
        tabla3.addCell(new Cell().add(new Paragraph("KILOMETRAJE").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("100562").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("TRACCION").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("DELANTERA").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("DISTRIBUCION").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("INDIRECTA").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("")));

//        //renglon 12
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("SUBMARCA").setFontSize(9).setBold().setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("FORD").setFontSize(9)).setTextAlignment(TextAlignment.CENTER));
        tabla3.addCell(new Cell().add(new Paragraph("MOTOR").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("L4").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("DIRECCIÓN").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("ELECTRÓNICA").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("# VALVULAS").setFontSize(9).setBold())
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("16").setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 13
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("MODELO").setBold().setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("2011")).setFontSize(9).setTextAlignment(TextAlignment.CENTER));
        tabla3.addCell(new Cell().add(new Paragraph("CILINDRADA").setBold()).setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("2").setFontSize(9).setTextAlignment(TextAlignment.CENTER)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("O ENCENDIDO").setBold()).setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("1-3-4-2").setFontSize(9).setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("COMUNICACION").setBold()).setFontSize(9)
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(220,230,242)));
        tabla3.addCell(new Cell().add(new Paragraph("OBD II CANBUS").setFontSize(9).setTextAlignment(TextAlignment.CENTER)));
        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 14 en blanco
        tabla3.addCell(new Cell(1,11).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 15
        Text str_Sintoma = new Text("[1] BREVE DESCRIPCIÓN DEL SÍNTOMA");
        str_Sintoma.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,2552));
        Paragraph par_Sintoma = new Paragraph();
        par_Sintoma.add(str_Sintoma);
        Text str_Problema = new Text("[2] VERIFICACIÓN DEL PROBLEMA");
        str_Problema.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,2552));
        Paragraph par_Problema = new Paragraph();
        par_Problema.add(str_Problema);
        tabla3.addCell(new Cell(1,5).add(par_Sintoma).setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(250,68,68)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(par_Problema).setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(112,48,160)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 16
        tabla3.addCell(new Cell(1,5).add(new Paragraph(edMSintoma.getText().toString())
            .setTextAlignment(TextAlignment.JUSTIFIED))); //input [1]Descripcion
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph(edMProblema.getText().toString())
            .setTextAlignment(TextAlignment.JUSTIFIED)));//input [2]problema
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 17 en blanco
        tabla3.addCell(new Cell(1,11).add(new Paragraph("")));

        //renglon 18
        Text str_QSintoma = new Text(" [1] POSIBLES CAUSA DEL SÍNTOMA");
            str_QSintoma.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_QSintoma = new Paragraph();
        par_QSintoma.add(str_QSintoma);
        Text str_PruBas = new Text("[3] PRUEBAS BÁSICAS");
            str_PruBas.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_PruBas = new Paragraph();
        par_PruBas.add(str_PruBas);
        tabla3.addCell(new Cell(1,5).add(par_QSintoma).setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(112,48,60)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(par_PruBas).setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(0,176,140)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 19
        tabla3.addCell(new Cell().add(new Paragraph("1").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Cuándo ocurrió el síntoma por primera vez?"))
                .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph(sp_Sintoma.getSelectedItem().toString()).
                setFontSize(8))); //input 1Q
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("STD").setBold()));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Tipo de batería")
            .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("1").setFontSize(8)));

        //renglon 20
        tabla3.addCell(new Cell().add(new Paragraph("2").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Se ha realizado algún tipo de servicio en meses pasados?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_servMesPasado.getSelectedItem().toString())
                .setFontSize(8))); //input serv mes pasado
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold())); //DIN
        tabla3.addCell(new Cell().add(new Paragraph(""))); //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Voltaje de batería sin arrancar")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("2").setFontSize(8)));

        //renglon 21
        tabla3.addCell(new Cell().add(new Paragraph("3").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Qué tipo de servicio se le ha practicado?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_tipoServicio.getSelectedItem().toString())
                .setFontSize(8))); //INput tipo de servicio
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Voltaje de batería al dar arranque")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("3").setFontSize(8)));

        //renglon 22
        tabla3.addCell(new Cell().add(new Paragraph("4").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Problemas al intentar arrancar o encender el vehículo?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_problemaEncender.getSelectedItem().toString())
                .setFontSize(8))); //INput problema al enceder
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Voltaje de batería al encender el motor")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("4").setFontSize(8)));

        //renglon 23
        tabla3.addCell(new Cell().add(new Paragraph("5").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("El motor se detiene"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_motorDetiene.getSelectedItem().toString())
                .setFontSize(8))); //DIN motor detiene
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Voltaje de batería al revolucionar motor a 1500 rpm")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("5").setFontSize(8)));

        //renglon 24
        tabla3.addCell(new Cell().add(new Paragraph("6").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Condiciones de ralentí"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_ralenti.getSelectedItem().toString())
                .setFontSize(8))); //DIN realenti
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Voltaje de batería al revolucionar motor a 3000 rpm")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("6").setFontSize(8)));

        //renglon 25
        tabla3.addCell(new Cell().add(new Paragraph("7").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Condiciones de funcionamiento"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_condFuncionamiento.getSelectedItem().toString())
                .setFontSize(8))); //DIN cond funcionamiento
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Amperaje de arranque para alternador")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("7").setFontSize(8)));

        //renglon 25
        tabla3.addCell(new Cell().add(new Paragraph("8").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Problemas con la transmisión "))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_probTransmicion.getSelectedItem().toString())
                .setFontSize(8))); //DIN prob. funcionamiento
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Amperaje de carga en el alternador")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("8").setFontSize(8)));

        //renglon 26
        tabla3.addCell(new Cell().add(new Paragraph("9").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Cuándo, generalmente, ocurre el síntoma de falla?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_ocurreFalla.getSelectedItem().toString())
                .setFontSize(8))); //DIN ocurre falla
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Estado del aceite de motor")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("9").setFontSize(8)));

        //renglon 27
        tabla3.addCell(new Cell().add(new Paragraph("10").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Cuál es la temperatura del motor al presentarse el síntoma?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_tempMotor.getSelectedItem().toString())
                .setFontSize(8))); //DIN temp motor
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Nivel de aceite de motor")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("10").setFontSize(8)));

        //renglon 28
        tabla3.addCell(new Cell().add(new Paragraph("11").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Condiciones de manejo durante la ocurrencia del síntoma"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_condicionManejoFalla.getSelectedItem().toString())
                .setFontSize(8))); //DIN manejo fallas
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Nivel del anticongelante")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("11").setFontSize(8)));

        //renglon 29
        tabla3.addCell(new Cell().add(new Paragraph("12").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Hábitos de manejo"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_habitosManejo.getSelectedItem().toString())
                .setFontSize(8))); //DIN modos manejo
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Estado del aceite de la transmisión")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("12").setFontSize(8)));

        //renglon 30
        tabla3.addCell(new Cell().add(new Paragraph("13").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Qué tipo de combustible suele usar en su vehículo?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_combustible.getSelectedItem().toString())
                .setFontSize(8))); //DIN combustible
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Nivel de aceite de la transmisión")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("13").setFontSize(8)));

        //renglon 31
        tabla3.addCell(new Cell().add(new Paragraph("14").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Se percibe algún tipo de olor?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_olor.getSelectedItem().toString()).setFontSize(8))); //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Presión y nivel de combustible")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("14").setFontSize(8)));

        //renglon 32
        tabla3.addCell(new Cell().add(new Paragraph("15").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Se percibe algún tipo de ruido?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_ruido.getSelectedItem().toString())
                .setFontSize(8))); //DIN olor
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Presión de vacío en colector de admisión")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("15").setFontSize(8)));

        //renglon 33
        tabla3.addCell(new Cell().add(new Paragraph("16").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Después de cuantos kilómetros se presenta el síntoma?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_kmSintoma.getSelectedItem().toString()).
                setFontSize(8))); //DIN-km sintoma
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Presión de compresión en cilindros")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("16").setFontSize(8)));

        //renglon 34
        tabla3.addCell(new Cell().add(new Paragraph("17").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿Cuántos kilómetros por día se conduce el vehículo?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_kmDia.getSelectedItem().toString())
                .setFontSize(8))); //DIN km/dia
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Estado y calibración de bujías")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("17").setFontSize(8)));

        //renglon 35
        tabla3.addCell(new Cell().add(new Paragraph("18").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("¿La luz indicadora de mal funcionamiento esta encendida?"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(sp_indicadorMalFuncionamiento.getSelectedItem().toString())
                .setFontSize(8))); //DIN luz indicadora
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Resistencia primaria y secundaria en bobinas")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("18").setFontSize(8)));

        //renglon 36
        tabla3.addCell(new Cell().add(new Paragraph("19").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph(""))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8)));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Señales de cmp")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("19").setFontSize(8)));

        //renglon 37
        tabla3.addCell(new Cell().add(new Paragraph("20").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph(""))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8)));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("12.4V").setBold()));  //DIN
        tabla3.addCell(new Cell().add(new Paragraph("")));                 //DIN
        tabla3.addCell(new Cell(1,2).add(new Paragraph("Señales de ckp")
                .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("20").setFontSize(8)));

        //renglon 38
        Text str_CodigosDiag = new Text("[4] CODIGOS DE DIAGNOSTICOS DE PROBLEMAS (DTC)");
        str_CodigosDiag.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_CodigosDiag = new Paragraph();
        par_CodigosDiag.add(str_CodigosDiag);
        Text str_InsVisual = new Text("[3] INSPECCIÓN VISUAL");
        str_InsVisual.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_InsVisual = new Paragraph();
        par_InsVisual.add(str_InsVisual);
        tabla3.addCell(new Cell(1,5).add(par_CodigosDiag).setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(new DeviceRgb(112,48,60)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(par_InsVisual).setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(new DeviceRgb(0,176,140)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 39
        tabla3.addCell(new Cell(1,2).add(new Paragraph("PCM"))
                    .setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("PSCM")
                .setBold().setTextAlignment(TextAlignment.CENTER).setFontSize(8)));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 40
        tabla3.addCell(new Cell(1,2).add(new Paragraph("P1116 ECT"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("U3000:53 Perdida de comunicación")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 41
        tabla3.addCell(new Cell(1,2).add(new Paragraph("P1703 brake swich out range"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("U3000:53-8A Fallo en modulo de control")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
            tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 42
        tabla3.addCell(new Cell(1,2).add(new Paragraph("P0420 catalyst system"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 43
        tabla3.addCell(new Cell(1,2).add(new Paragraph("P0480 circuit control"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 44
        Text str_Boletines = new Text("[5] REVISION DE BOLETINES TÉCNICOS");
        str_Boletines.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_Boletines = new Paragraph();
        par_Boletines.add(str_Boletines);
        tabla3.addCell(new Cell(1,2).add(new Paragraph("ABS"))
                    .setFontSize(8).setTextAlignment(TextAlignment.CENTER));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(par_Boletines.setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(112,48,60))));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 44
        tabla3.addCell(new Cell(1,2).add(new Paragraph("C0031:15-60 SSV izquierda"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 45
        tabla3.addCell(new Cell(1,2).add(new Paragraph("C0034:15-60 SSV derecha"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 46
            tabla3.addCell(new Cell(1,2).add(new Paragraph("C0037:07-60 SSV"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
            tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
            tabla3.addCell(new Cell().add(new Paragraph("")));
            tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 47
        tabla3.addCell(new Cell(1,2).add(new Paragraph("C003A:07-60 SSV"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 48
        tabla3.addCell(new Cell(1,2).add(new Paragraph("U0401:00-60 Comunicación"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 49
        tabla3.addCell(new Cell(1,2).add(new Paragraph("U3003:16-60 voltaje de batería"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 50
        tabla3.addCell(new Cell(1,2).add(new Paragraph("BCM"))
                    .setFontSize(8).setTextAlignment(TextAlignment.CENTER));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
            tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
            tabla3.addCell(new Cell().add(new Paragraph("")));
            tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 51
        tabla3.addCell(new Cell(1,2).add(new Paragraph("B10BD:11-40 malfuncionamiento interruptor"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 52
        tabla3.addCell(new Cell(1,2).add(new Paragraph("B10BD:13-C8 malfuncionamiento interruptor"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 53
        tabla3.addCell(new Cell(1,2).add(new Paragraph("B10BD:23-CC malfuncionamiento interruptor"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 54
        tabla3.addCell(new Cell(1,2).add(new Paragraph("U0159:00-4C Perdida de comunicación"))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 55
        tabla3.addCell(new Cell(1,2).add(new Paragraph(""))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 56
        tabla3.addCell(new Cell(1,2).add(new Paragraph(""))
                    .setFontSize(8));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));
//        tabla3.addCell(new Cell().add(new Paragraph("")));

        //renglon 57
        Text str_SisInv = new Text("[7] SISTEMAS INVOLUCRADOS PARA EL DIAGNOSTICO");
        str_SisInv.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_SisInv = new Paragraph();
        par_SisInv.add(str_SisInv);
        Text str_AnDatos = new Text("[6] ANÁLISIS DE DATOS EN VIVO REELEVANTES");
        str_AnDatos.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_AnDatos = new Paragraph();
        par_AnDatos.add(str_AnDatos);
        tabla3.addCell(new Cell(1,5).add(par_SisInv).setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(new DeviceRgb(112,48,60)));
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell(1,5).add(par_AnDatos).setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(new DeviceRgb(112,48,60)));

        //renglon 58
        tabla3.addCell(new Cell().add(new Paragraph("1").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA MECÁNICO"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Sensor de torque ")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("1").setFontSize(8)));

        //renglon 59
        tabla3.addCell(new Cell().add(new Paragraph("2").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE LUBRICACIÓN"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Amperaje de servomotor")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("2").setFontSize(8)));

        //renglon 60
        tabla3.addCell(new Cell().add(new Paragraph("3").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE IGNICIÓN"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Temperatura de dirección electro asistida")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("3").setFontSize(8)));

        //renglon 61
        tabla3.addCell(new Cell().add(new Paragraph("4").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE INYECCIÓN"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Voltaje de alimentación 1 ")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("4").setFontSize(8)));

        //renglon 62
        tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE ADMISIÓN"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("Voltaje de alimentación 2")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("5").setFontSize(8)));

        //renglon 63
        tabla3.addCell(new Cell().add(new Paragraph("6").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE ESCAPE"))
                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph(" ")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("6").setFontSize(8)));

        //renglon 64
        tabla3.addCell(new Cell().add(new Paragraph("7").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE ENFRIAMIENTO"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("7").setFontSize(8)));

        //renglon 65
        tabla3.addCell(new Cell().add(new Paragraph("8").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE AIRE ACONDICIONADO"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("8").setFontSize(8)));

        //renglon 66
        tabla3.addCell(new Cell().add(new Paragraph("9").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA ELECTRICO"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("9").setFontSize(8)));

        //renglon 67
        tabla3.addCell(new Cell().add(new Paragraph("10").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA ELECTRONICO"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("10").setFontSize(8)));

        //renglon 68
        tabla3.addCell(new Cell().add(new Paragraph("11").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE FRENOS"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("11").setFontSize(8)));

        //renglon 69
        tabla3.addCell(new Cell().add(new Paragraph("12").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE SUSPENCIÓN"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("12").setFontSize(8)));

        //renglon 70
        tabla3.addCell(new Cell().add(new Paragraph("13").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE DIRECCIÓN"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("13").setFontSize(8)));

        //renglon 71
        tabla3.addCell(new Cell().add(new Paragraph("14").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE TRANSMISION"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("14").setFontSize(8)));

        //renglon 72
        tabla3.addCell(new Cell().add(new Paragraph("15").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE ARRANQUE"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("15").setFontSize(8)));

        //renglon 73
        tabla3.addCell(new Cell().add(new Paragraph("16").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA DE CARGA"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("16").setFontSize(8)));

        //renglon 74
        tabla3.addCell(new Cell().add(new Paragraph("17").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph("SISTEMA HIBRIDO"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("17").setFontSize(8)));

        //renglon 75
        tabla3.addCell(new Cell().add(new Paragraph("1").setFontSize(8)));
        tabla3.addCell(new Cell(1,3).add(new Paragraph(""))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph(""))); //input
        tabla3.addCell(new Cell().add(new Paragraph("")));
        tabla3.addCell(new Cell().add(new Paragraph("")));// input
        tabla3.addCell(new Cell(1,3).add(new Paragraph("")
                    .setFontSize(8).setTextAlignment(TextAlignment.RIGHT)));
        tabla3.addCell(new Cell().add(new Paragraph("1").setFontSize(8)));

        //renglon 76
        Text str_RepSintoma = new Text("[8] REPARACION DEL SINTOMA DE FALLA Y CAUSA RAÍZ");
        str_RepSintoma.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_RepSintoma = new Paragraph();
        par_RepSintoma.add(str_RepSintoma);
        Text str_RRPC = new Text("REFACCIONES, REPUESTOS, PARTES Y CONSUMIBLES");
        str_RRPC.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
        Paragraph par_RRPC = new Paragraph();
        par_RRPC.add(str_RRPC);
        tabla3.addCell(new Cell(1,5).add(par_RepSintoma).setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(new DeviceRgb(112,48,60)));
        tabla3.addCell(new Cell().add(new Paragraph("No")));
        tabla3.addCell(new Cell(1,4).add(par_RRPC).setTextAlignment(TextAlignment.CENTER)
                    .setBackgroundColor(new DeviceRgb(112,48,60)));
        tabla3.addCell(new Cell().add(new Paragraph("Cant.")));

        //renglon 77
        tabla3.addCell(new Cell(15,5).add(new Paragraph("SISTEMA MECÁNICO"))
                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph("1")));
        tabla3.addCell(new Cell(1,4).add(new Paragraph("Dirección electro asistida")));// input
        tabla3.addCell(new Cell().add(new Paragraph("1").setFontSize(8)));//input

        //renglon 78
//        tabla3.addCell(new Cell(1,5).add(new Paragraph("SISTEMA MECÁNICO"))
//                .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph("2")));
        tabla3.addCell(new Cell(1,4).add(new Paragraph("1 galón de Liquido anticongelante")));// input
        tabla3.addCell(new Cell().add(new Paragraph("1").setFontSize(8)));//input

        //renglon 79
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
        tabla3.addCell(new Cell().add(new Paragraph("3")));
        tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
        tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 80
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("4")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 81
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("5")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 82
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("6")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 83
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("7")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 84
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("8")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 85
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("9")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 86
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("10")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 87
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("11")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 88
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("12")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 89
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("13")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 90
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("14")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 91
//        tabla3.addCell(new Cell(1,5).add(new Paragraph(""))
//                    .setFontSize(8));
            tabla3.addCell(new Cell().add(new Paragraph("15")));
            tabla3.addCell(new Cell(1,4).add(new Paragraph("")));// input
            tabla3.addCell(new Cell().add(new Paragraph("").setFontSize(8))); //input

            //renglon 92
            tabla3.addCell(new Cell(1,11).add(new Paragraph("")));

            //renglon 92
            Text str_TCond = new Text("TERMINOS Y CONDICIONES NOM-68-SCFI-2000");
            str_TCond.setFontSize(12).setBold().setFontColor(new DeviceRgb(255,255,255));
            Paragraph par_TCond = new Paragraph();
            par_TCond.add(str_TCond);
            tabla3.addCell(new Cell(1,11).add(par_TCond)
                    .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(new DeviceRgb(0,146,240)));

            //renglon 92
            Text str_Norma = new Text("A. EL TALLER \"MECAS\" ESTÁ OBLIGADO A PROPORCIONAR UN "+
                    "SERVICIO DE CALIDAD A TODOS SUS CONSUMIDORES, GARANTIZADO LOS PROCEDIMIENTOS "+
                    "DE DIAGNÓSTICO, LA MANO DE OBRA, LAS PRUEBAS Y MEDICIONES REALIZADAS EN LOS "+
                    "SERVICIOS DE REPARACIÓN Y/O MANTENIMIENTO, VALIDANDO LA GRARANTIA SIN COSTO "+
                    "ALGUNO POR UN PERIODO DE 8 DÍAS, SALVO EN CASO DE PARTES O REFACCIONES.\n"+
                    "B. UNA VEZ QUE EL CONSUMIDOR FIRME LA ORDEN DE SERVICIO, EL TALLER \"MECAS\" "+
                    "DEBE LLEVAR LA REPARACIÓN Y/O MANTENIMIENTO DEL VEHÍCULO, RESPENTANDO TERMINOS "+
                    "Y CONDICIONES, UTILIZANDO PARTES, REFACCIONES U OTROS MATERIALES APROPIADOS AL "+
                    "MODELO Y MARCA DEL VEHIÍCULO, SALVO QUE EL CONSUMIDOR AUTORICE QUE SE UTILICEN "+
                    "PARTES O REFACCONES USADAS O RECONSTRUIDAS, UTILIZANDO EL VEHÍCULO UNICAMENTE "+
                    "PARA REALIZAR RECORRIDOS DE PRUEBA EN LAS ZONAS ALEDAÑAS.\n"+
                    "C. EL CONSUMIDOR PUEDE DESISTIRCE EN CUALQUIER MOMENTO DE LA CONTRATACIÓN DE "+
                    "SERVICIO DE REPARACIÓN Y/O MANTENIMINETO DEL VEHÍCULO, EN CUYO CASO DEBERÁ "+
                    "CUBRIR, EN LUGAR DEL PRECIO CONTRATADO, EL IMPORTE DE LOS TRABAJOS REALIZADOS "+
                    "HASTA EL RETIRO DEL VEHÍCULO, INCLUIDAD LAS PARTES, REFACCIONES U OTROS "+
                    "MATERIALES UTILIZADOS.");
            str_Norma.setFontSize(7).setBold();
            Paragraph par_Norma = new Paragraph();
            par_Norma.add(str_Norma);
            tabla3.addCell(new Cell(1,11).add(par_Norma)
                    .setTextAlignment(TextAlignment.JUSTIFIED));



//        java.text.SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy / MM / dd");
//        String fecha1 = fechaFormat.format(new Date());

//        Time fecha = new Time();
//        fecha.setToNow();
//        tabla3.addCell(new Cell().add(new Paragraph("Date")));
//        tabla3.addCell(new Cell().add(new Paragraph(fecha1)));
//
//        tabla3.addCell(new Cell().add(new Paragraph("Phone")));
//        tabla3.addCell(new Cell().add(new Paragraph("5551525621")));
//
//        SimpleDateFormat tiempoFormat = new SimpleDateFormat("HH:mm:ss");
//        String tiempo = tiempoFormat.format(new Date().getTime());
//        tabla3.addCell(new Cell().add(new Paragraph("Time")));
//        tabla3.addCell(new Cell().add(new Paragraph(tiempo)));

//        BarcodeQRCode codigo =  new BarcodeQRCode(name+"\n"+age+"\n"+location+"\n"+
//                fecha1 + "\n" + tiempo);
//        PdfFormXObject qrCodigo = codigo.createFormXObject(Color.BLACK, documentPDF);
//        Image codigoImg = new Image(qrCodigo).setWidth(80).setHorizontalAlignment(HorizontalAlignment.CENTER);

//        doc.add(img);
//        doc.add(ingreso);
//        doc.add(par1);
//        doc.add(par2);
        doc.add(tabla3);
//        doc.add(codigoImg);
        doc.close();

//        Toast.makeText(this,rutaPDF.getPath().toString(),Toast.LENGTH_LONG).show();
        Toast.makeText(this,"Archivo Creado",Toast.LENGTH_LONG).show();
     }


        private void createPDFButton(String name, String age, String location) throws FileNotFoundException {
            String rutaPDF = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
            File archivo = new File(rutaPDF, "MECAS_1.pdf");
            FileOutputStream outStream = new FileOutputStream(archivo);

            PdfWriter escritor = new PdfWriter(archivo);
            PdfDocument documentPDF = new PdfDocument(escritor);
            Document doc = new Document(documentPDF);

            documentPDF.setDefaultPageSize(PageSize.LETTER);  //tamanho de pagina
            doc.setMargins(0, 0, 0, 0); //margenes de

            Drawable dr = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                dr = getDrawable(R.drawable.mecas);
            }
            Bitmap mapBit = ((BitmapDrawable) dr).getBitmap();
            ByteArrayOutputStream strm = new ByteArrayOutputStream();
            mapBit.compress(Bitmap.CompressFormat.PNG, 100, strm);
            byte[] dataBitmap = strm.toByteArray();
            ImageData dataImage = ImageDataFactory.create(dataBitmap);
            Image img = new Image(dataImage);

            Paragraph ingreso = new Paragraph("Ingreso").setBold().setFontSize(24).setTextAlignment(TextAlignment.CENTER);
            Paragraph par1 =  new Paragraph("INGRESANDO \n MECAS garage").setTextAlignment(TextAlignment.CENTER);
            Paragraph par2 = new Paragraph("GLINTEC").setTextAlignment(TextAlignment.CENTER);

            float [] widthCell = {100, 100};
            Table tabla3 = new Table(widthCell);
            tabla3.setHorizontalAlignment(HorizontalAlignment.CENTER);

            tabla3.addCell(new Cell().add(new Paragraph("Visitor name")));
            tabla3.addCell(new Cell().add(new Paragraph(name)));

            tabla3.addCell(new Cell().add(new Paragraph("Age")));
            tabla3.addCell(new Cell().add(new Paragraph(age)));

            tabla3.addCell(new Cell().add(new Paragraph("Location")));
            tabla3.addCell(new Cell().add(new Paragraph(location)));

            java.text.SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy / MM / dd");
            String fecha1 = fechaFormat.format(new Date());
//            DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd MM yyyy");
            Time fecha = new Time();
            fecha.setToNow();
            tabla3.addCell(new Cell().add(new Paragraph("Date")));
//            tabla3.addCell(new Cell().add(new Paragraph(LocalDate.now().format(dateFormat).toString())));
//            tabla3.addCell(new Cell().add(new Paragraph(fecha.format("%d/%mm/%yyyy").toString())));
            tabla3.addCell(new Cell().add(new Paragraph(fecha1)));

            tabla3.addCell(new Cell().add(new Paragraph("Phone")));
            tabla3.addCell(new Cell().add(new Paragraph("5551525621")));

//            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss a");
            SimpleDateFormat tiempoFormat = new SimpleDateFormat("HH:mm:ss");
            String tiempo = tiempoFormat.format(new Date().getTime());
            tabla3.addCell(new Cell().add(new Paragraph("Time")));
//            tabla3.addCell(new Cell().add(new Paragraph(LocalTime.now().format(timeFormat).toString())));
            tabla3.addCell(new Cell().add(new Paragraph(tiempo)));

//            BarcodeQRCode codigo =  new BarcodeQRCode(name+"\n"+age+"\n"+location+"\n"+
//                    LocalDate.now().format(dateFormat).toString());
            BarcodeQRCode codigo =  new BarcodeQRCode(name+"\n"+age+"\n"+location+"\n"+
                    fecha1 + "\n" + tiempo);
            PdfFormXObject qrCodigo = codigo.createFormXObject(Color.BLACK, documentPDF);
            Image codigoImg = new Image(qrCodigo).setWidth(80).setHorizontalAlignment(HorizontalAlignment.CENTER);

            doc.add(img);
            doc.add(ingreso);
            doc.add(par1);
            doc.add(par2);
            doc.add(tabla3);
            doc.add(codigoImg);
            doc.close();
        Toast.makeText(this,"Archivo creado desde Boton",Toast.LENGTH_LONG).show();
        }

        private void createPDF() throws FileNotFoundException {

        Toast.makeText(this, "INICIANDO.", Toast.LENGTH_LONG).show();
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new  File(pdfPath,"Mecas.pdf");
        FileOutputStream outputStream = new FileOutputStream(file);

        PdfWriter writer = new PdfWriter(file);
//        com.itextpdf.kernel.pdf.PdfDocument pdfdocument = new com.itextpdf.kernel.pdf.PdfDocument(writer);
        PdfDocument pdfdocument = new PdfDocument(writer);
        Document document = new Document(pdfdocument);

        Paragraph paragraph = new Paragraph("Welcome MECAS!!!");

        Text texto1 = new Text("MECAS garage \n").setBold();
        Text texto2 = new Text("MECAS garage \n").setItalic();
        Text texto3 = new Text("MECAS garage ").setUnderline();
        Paragraph phar1 = new Paragraph();

        phar1.add(texto1)
                .add(texto2)
                .add(texto3);

        //CREACION DE UNA LISTA
        List lista = new List();
//        lista.setListSymbol("\u00A5"); //agregar simbolo en el listado
//        lista.setListSymbol(imagen);  //agregar una imagen como simbolo del listado (necesario crear obj imagen)
        lista.add("falla");
        lista.add("Compostura");
        lista.add("Salida");
        lista.add("Factura");
        lista.add("Refacciones");
        lista.add("Diagnostico");

        //CREACION DE UNA IMAGEN
            Drawable dibujo = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                dibujo = getDrawable(R.drawable.mecas);
            }
            Bitmap bitmap = ((BitmapDrawable)dibujo).getBitmap();
        ByteArrayOutputStream cadena = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,cadena);
        byte[] bitmapData = cadena.toByteArray();
        ImageData imagenData = ImageDataFactory.create(bitmapData);
        Image imagen = new Image(imagenData);
        imagen.setHeight(30);
        imagen.setWidth(50);

        //CREACION DE UNA TABLA
        Border borde1 = new GrooveBorder(2);
        // Border / Border3D / DashedBorder / DottedBorder / DoubleBorder /FixedDashedBorder
        //GrooveBorder / InsetBorder / OutsetBorder / RidgeBorder / RoundDotBorder / SolidBorder
        float colwidth[]={200f,200f};
        Table tabla = new Table(colwidth);
        tabla.addCell(new Cell().setBackgroundColor(Color.BLUE).setBorder(borde1).add(new Paragraph("Nombre")));
        tabla.addCell(new Cell().setBackgroundColor(new DeviceRgb(125,125,125)).add(new Paragraph("Marca")));

        tabla.addCell(new Cell(2,1).add(new Paragraph("Ubinio Chayan ")));
        tabla.addCell("SMART");
//        tabla.addCell("Nombre 2");
        tabla.addCell("FOCUS");
        tabla.setBorder(borde1);

        //EJEMPLO CREACION DE UNA HOJA DE DOCUMENTO
        float colwidth1[]={112, 112, 112, 112, 112};
        Table tabla2 = new Table(colwidth1);
        //row #1
        tabla2.addCell(new Cell(1,2).add(new Paragraph("MECAS garage")
        .setFontSize(21f).setBold().setFontColor(new DeviceRgb(15,100,15))).setBorder(Border.NO_BORDER));
//        tabla2.addCell(new Cell().add(new Paragraph("")));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));

        //row 2
        tabla2.addCell(new Cell().add(new Paragraph("Av. Nvo Mexico ")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("55651262\nMecas@glintec.com\nglintec.com")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));

        //row #3
        tabla2.addCell(new Cell().add(new Paragraph("\n")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));

        //row #4
        Text infoCliente = new Text("Cliente\n");
        infoCliente.setBold().setFontColor(new DeviceRgb(10,10,200));
        Paragraph paraInfo = new Paragraph();
        paraInfo.add(infoCliente);
        paraInfo.add("Dirección\nTelefono");
//        tabla2.addCell(new Cell().add(new Paragraph("Cliente\nDirección\nTelefono")));
        tabla2.addCell(new Cell().add(paraInfo).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));

        //row #5
        tabla2.addCell(new Cell(2,1).add(new Paragraph("Invoice")).setBold()
            .setFontSize(24f).setFontColor(new DeviceRgb(10,50,100)).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));

        //row #6
//        tabla2.addCell(new Cell().add(new Paragraph("")));
        tabla2.addCell(new Cell().add(new Paragraph("DESCRIPTION")).setFontColor(Color.ORANGE).setBackgroundColor(Color.DARK_GRAY));
        tabla2.addCell(new Cell().add(new Paragraph("UNIT COST")).setFontColor(Color.ORANGE).setBackgroundColor(Color.DARK_GRAY));
        tabla2.addCell(new Cell().add(new Paragraph("QTY")).setFontColor(Color.ORANGE).setBackgroundColor(Color.DARK_GRAY));
        tabla2.addCell(new Cell().add(new Paragraph("AMOUNT")).setFontColor(Color.ORANGE).setBackgroundColor(Color.DARK_GRAY));

        //row #7
        Text textInvoicNum = new Text("INVOICE NUMBER\n");
        textInvoicNum.setBold().setFontColor(new DeviceRgb(10,25,244));
        Paragraph parInvoiceNum = new Paragraph();
        parInvoiceNum.add(textInvoicNum);
        parInvoiceNum.add("00001");
//        tabla2.addCell(new Cell(2,1).add(new Paragraph("INVOICE NUMBER\n 00001")));
        tabla2.addCell(new Cell(2,1).add(parInvoiceNum).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("Item name ")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("1")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(Color.YELLOW));

        //row #8
//        tabla2.addCell(new Cell().add(new Paragraph("")));
        tabla2.addCell(new Cell().add(new Paragraph("Item name")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("1")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(Color.YELLOW));

        //row #9
        Text textDate = new Text("Date of Issue\n");
        textDate.setBold().setFontColor(new DeviceRgb(10,192,33));
        Paragraph parDate = new Paragraph();
        parDate.add(textDate);
        parDate.add("21/3/21");
//        tabla2.addCell(new Cell(2,1).add(new Paragraph("Date of Issue\n21/3/21")));
        tabla2.addCell(new Cell(2,1).add(parDate).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("Item name")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("100")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("2")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("200")).setBackgroundColor(Color.YELLOW));

        //row #10
//        tabla2.addCell(new Cell().add(new Paragraph("")));
        tabla2.addCell(new Cell().add(new Paragraph("Item name")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("200")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("2")).setBackgroundColor(Color.YELLOW));
        tabla2.addCell(new Cell().add(new Paragraph("333")).setBackgroundColor(Color.YELLOW));

        //row #11
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));

        //row #12
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("SUBTOTAL")).setFontColor(Color.RED));
        tabla2.addCell(new Cell().add(new Paragraph("500")));

        //row #13
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("DISCOUNT")).setFontColor(Color.RED));
        tabla2.addCell(new Cell().add(new Paragraph("0")));

        //row #14
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("TAX RATE")).setFontColor(Color.RED));
        tabla2.addCell(new Cell().add(new Paragraph("20%")));

        //row #15
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("TAX")).setFontColor(Color.RED));
        tabla2.addCell(new Cell().add(new Paragraph("40%")));

        //row #16
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell(1,2).add(new Paragraph("-----")).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
//        tabla2.addCell(new Cell().add(new Paragraph("")));

        //row #17
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        Text textTotal = new Text("Invoice Total\n");
        textTotal.setFontColor(Color.BLUE).setFontSize(20);
        Paragraph parTotal = new Paragraph();
        parTotal.add(textTotal);
        parTotal.add("440");
//        tabla2.addCell(new Cell(1,2).add(new Paragraph("Invoice Total'\n 440")));
        tabla2.addCell(new Cell(1,2).add(parTotal));
//        tabla2.addCell(new Cell().add(new Paragraph("")));

        //row #18
        tabla2.addCell(new Cell(1,2).add(new Paragraph("TERMS")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        tabla2.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));


        //CREACION DE BARCODE
//        BarcodeQRCode qrCode = new BarcodeQRCode("Hello MECAS garage!!!");
//        BarcodeQRCode qrCode = new BarcodeQRCode("http://glintec.com");
        BarcodeQRCode qrCode = new BarcodeQRCode("mailto:Ubinio@mecas.com?subject=carro%20focus&body&body=cotizacion");
        PdfFormXObject barCodeObj =  qrCode.createFormXObject(Color.BLACK, pdfdocument);
        Image barCodeImg = new Image(barCodeObj).setWidth(100).setHeight(100);


        document.add(paragraph);
        document.add(phar1);
        document.add(lista);
//        document.add(imagen);
        document.add(tabla);
        document.add(barCodeImg);
        document.add(tabla2);
        document.add(new Paragraph("\n\n\nAuthorized signature"));
        document.close();
        Toast.makeText(this, "PDF creado.", Toast.LENGTH_LONG).show();
    }

}
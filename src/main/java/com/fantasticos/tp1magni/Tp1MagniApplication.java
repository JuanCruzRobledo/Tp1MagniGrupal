package com.fantasticos.tp1magni;

import com.fantasticos.tp1magni.persistence.entities.Empresa;
import com.fantasticos.tp1magni.persistence.entities.Noticia;
import com.fantasticos.tp1magni.persistence.repository.EmpresaRepository;
import com.fantasticos.tp1magni.persistence.repository.NoticiaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp1MagniApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp1MagniApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EmpresaRepository empresaRepository, NoticiaRepository noticiaRepository) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //EMPRESA EL SOL
            Empresa empresaElSol = Empresa.builder()
                    .denominacion("EL Sol")
                    .telefono("+54 11 1234-5678")
                    .horarioAtencion("Lunes a Viernes de 8:00 a 18:00 hs")
                    .quienesSomos("Somos un medio de comunicación digital comprometido con la verdad y la objetividad, brindando noticias en tiempo real sobre política, economía, tecnología y más.")
                    .latitud(-34.603722)
                    .longitud(-58.381592)
                    .domicilio("Av. Siempre Viva 742, Buenos Aires, Argentina")
                    .email("contacto@noticiashoy.com")
                    .build();

            Noticia empresaElSolnoticia1 = Noticia.builder()
                    .tituloNoticia("Descubren Ciudad Perdida Bajo el Desierto del Sahara")
                    .resumenNoticia("Arqueólogos afirman haber encontrado una metrópolis oculta bajo las arenas del Sahara, repleta de templos y tecnología avanzada que podría cambiar la historia de la humanidad.")
                    .imagenNoticia("https://resizer.glanacion.com/resizer/v2/el-sahara-se-extiende-a-lo-largo-de-4800-AEPKCH33KZHFZGWCOFTRTHXTEM.jpg?auth=d3cfa3a833cc0fa628c1f499f877071cdc88920d493f02f15a2963fab9c3731f&width=1280&height=854&quality=70&smart=true")
                    .contenidoHtml("<h1>Se ha descubierto una ciudad antigua...</h1>")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-04-30"))
                    .empresa(empresaElSol)
                    .build();

            Noticia empresaElSolnoticia2 = Noticia.builder()
                    .tituloNoticia("Científicos crean una fruta que sabe a pizza")
                    .resumenNoticia("Un equipo de biólogos ha desarrollado una fruta híbrida que tiene el sabor exacto de una pizza margarita, revolucionando la industria alimentaria y sorprendiendo a expertos en gastronomía.")
                    .imagenNoticia("https://imag.bonviveur.com/pizza-margarita.jpg")
                    .contenidoHtml("<h1>Un nuevo descubrimiento en el mundo de la alimentación...</h1>")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2025-01-29"))
                    .empresa(empresaElSol)
                    .build();

            Noticia empresaElSolnoticia3 = Noticia.builder()
                    .tituloNoticia("Avistamiento de un supuesto dragón en los Alpes suizos")
                    .resumenNoticia("Turistas aseguran haber visto una criatura alada sobrevolando los Alpes suizos. Expertos intentan explicar el misterioso avistamiento mientras las redes sociales se inundan de videos y fotos del fenómeno.")
                    .imagenNoticia("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/33/f9/1c/swiss-alps.jpg?w=1200&h=700&s=1")
                    .contenidoHtml("<h1>Un fenómeno inexplicable...</h1>")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-11-10"))
                    .empresa(empresaElSol)
                    .build();

            Noticia empresaElSolnoticia4 = Noticia.builder()
                    .tituloNoticia("NASA confirma que encontraron señales de vida en un planeta lejano")
                    .resumenNoticia("Científicos de la NASA aseguran haber detectado señales de radio provenientes de un exoplaneta a más de 200 años luz, lo que podría ser evidencia de vida inteligente fuera de la Tierra.")
                    .imagenNoticia("https://starwalk.space/gallery/images/what-is-space/1920x1080.jpg")
                    .contenidoHtml("<h1>Descubrimientos astronómicos sin precedentes...</h1>")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-09-02"))
                    .empresa(empresaElSol)
                    .build();

            Noticia empresaElSolnoticia5 = Noticia.builder()
                    .tituloNoticia("Una isla flotante es avistada en el océano Pacífico")
                    .resumenNoticia("Un barco pesquero reporta haber encontrado una isla flotante de grandes dimensiones en el Pacífico, causando asombro entre científicos y aventureros que se alistan para investigar el fenómeno.")
                    .imagenNoticia("https://fotografias.lasexta.com/clipping/cmsimages01/2016/05/11/79D88ED6-5E71-463F-906B-D3FB109FD70F/98.jpg?crop=1000,563,x0,y3&width=1900&height=1069&optimize=low&format=webply")
                    .contenidoHtml("<h1>Una isla que desafía la lógica...</h1>")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2023-11-12"))
                    .empresa(empresaElSol)
                    .build();



            // EMPRESA DIARIO UNO
            Empresa empresaDiarioUno = Empresa.builder()
                    .denominacion("Diario Uno")
                    .telefono("+54 341 234-5678")
                    .horarioAtencion("Lunes a Domingo de 7:00 a 22:00 hs")
                    .quienesSomos("El Reportero Global es un periódico digital independiente que ofrece análisis profundos y noticias actualizadas sobre eventos internacionales, cultura y tecnología.")
                    .latitud(40.416775)
                    .longitud(-3.703790)
                    .domicilio("Calle Mayor 123, Madrid, España")
                    .email("info@reporteroglobal.com")
                    .build();

            Noticia diarioUnoEmpresaNoticia1 = Noticia.builder()
                    .tituloNoticia("Encuentran un portal a otra dimensión en el Antártico")
                    .resumenNoticia("Un equipo de científicos en la Antártida ha descubierto una anomalía geológica que podría ser un portal hacia otra dimensión, lo que ha causado gran asombro en la comunidad científica mundial.")
                    .imagenNoticia("https://static.nationalgeographicla.com/files/styles/image_3200/public/nationalgeographic_2815258.jpg?w=1600&h=901")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2025-02-11"))
                    .empresa(empresaDiarioUno)
                    .build();

            Noticia diarioUnoEmpresaNoticia2 = Noticia.builder()
                    .tituloNoticia("La NASA encuentra un planeta habitable en la zona de Orión")
                    .resumenNoticia("La NASA ha anunciado el hallazgo de un planeta en la zona de Orión que podría ser habitable, lo que abre nuevas posibilidades para la expansión humana más allá de la Tierra.")
                    .imagenNoticia("https://elseptimocielo.fundaciondescubre.es/files/2020/07/AdobeStock_238169477.jpeg")
                    .contenidoHtml("")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2025-05-20"))
                    .empresa(empresaDiarioUno)
                    .build();

            Noticia diarioUnoEmpresaNoticia3 = Noticia.builder()
                    .tituloNoticia("Un equipo de arqueólogos descubre una antigua nave vikinga en el fondo del mar")
                    .resumenNoticia("Arqueólogos marinos han descubierto una antigua nave vikinga en las profundidades del océano Atlántico, con artefactos que datan de más de mil años.")
                    .imagenNoticia("https://www.cronista.com/files/image/893/893811/669920ea64ca7.jpg")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2025-01-11"))
                    .empresa(empresaDiarioUno)
                    .build();

            Noticia diarioUnoEmpresaNoticia4 = Noticia.builder()
                    .tituloNoticia("Un dinosaurio vivo es encontrado en una isla remota del Pacífico")
                    .resumenNoticia("Un equipo de exploradores ha reportado el hallazgo de una especie de dinosaurio viviente en una isla remota del Pacífico, lo que desafía todo lo que se sabía sobre la extinción de estos reptiles.")
                    .imagenNoticia("https://static.nationalgeographicla.com/files/styles/image_3200/public/sidersaura-2.webp?w=1600&h=900&p=left")
                    .contenidoHtml("")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2023-12-13"))
                    .empresa(empresaDiarioUno)
                    .build();

            Noticia diarioUnoEmpresaNoticia5 = Noticia.builder()
                    .tituloNoticia("El gobierno mundial revela que existen extraterrestres entre nosotros")
                    .resumenNoticia("Fuentes oficiales han confirmado que extraterrestres han estado viviendo en la Tierra de manera encubierta durante siglos, y que la humanidad pronto conocerá la verdad.")
                    .imagenNoticia("https://images.ecestaticos.com/mjWHjFRqDoU6ERnf-U5j_UoJHSo=/0x0:2121x1414/1200x675/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F048%2Fd92%2Fed4%2F048d92ed4c3bfa69ad53f67e3239b785.jpg")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-03-10"))
                    .empresa(empresaDiarioUno)
                    .build();


            // EMPRESA LA NACIÓN
            Empresa empresaLaNacion = Empresa.builder()
                    .denominacion("La Nación")
                    .telefono("+54 351 678-9012")
                    .horarioAtencion("24 horas, todos los días")
                    .quienesSomos("Noticias al Instante es un portal de noticias en tiempo real que cubre los acontecimientos más importantes de América Latina y el mundo, con información verificada y objetiva.")
                    .latitud(25.761680)
                    .longitud(-80.191790)
                    .domicilio("1234 Brickell Ave, Miami, FL, EE.UU")
                    .email("contacto@noticiasalinstante.com")
                    .build();

            Noticia laNacionEmpresaNoticia1 = Noticia.builder()
                    .tituloNoticia("Un volcán activo se ha formado en pleno desierto del Sahara")
                    .resumenNoticia("Científicos han confirmado que un volcán ha emergido en el desierto del Sahara, desafiando toda lógica geológica y causando preocupación en las comunidades cercanas.")
                    .imagenNoticia("https://upload.wikimedia.org/wikipedia/commons/4/48/Chad_Tousside.jpg")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2023-12-12"))
                    .empresa(empresaLaNacion)
                    .build();

            Noticia laNacionEmpresaNoticia2 = Noticia.builder()
                    .tituloNoticia("Una civilización extraterrestre envía un mensaje a la humanidad desde Marte")
                    .resumenNoticia("Investigadores de la NASA han interceptado señales misteriosas que se cree provienen de una civilización avanzada en Marte, lo que podría significar el primer contacto con vida inteligente fuera de la Tierra.")
                    .imagenNoticia("https://futuroelectrico.com/wp-content/uploads/2022/09/curiosidades-de-marte.jpg")
                    .contenidoHtml("")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2024-06-16"))
                    .empresa(empresaLaNacion)
                    .build();

            Noticia laNacionEmpresaNoticia3 = Noticia.builder()
                    .tituloNoticia("Se descubre una gigantesca ciudad subterránea bajo las pirámides de Egipto")
                    .resumenNoticia("Un equipo de arqueólogos ha hallado una vasta ciudad subterránea oculta debajo de las famosas pirámides de Egipto, lo que cambiaría nuestra comprensión de la historia antigua.")
                    .imagenNoticia("https://basadoenhechosreales.com.ar/wp-content/uploads/que-surgio-en-egipto-2.webp")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-10-25"))
                    .empresa(empresaLaNacion)
                    .build();

            Noticia laNacionEmpresaNoticia4 = Noticia.builder()
                    .tituloNoticia("Un grupo de científicos asegura haber encontrado el elixir de la eterna juventud")
                    .resumenNoticia("Científicos de renombre mundial han desarrollado un tratamiento que promete ralentizar significativamente el envejecimiento y potencialmente otorgar vida eterna, un avance que ha desatado un debate ético global.")
                    .imagenNoticia("https://www.ospat.com.ar/wp-content/uploads/2021/04/suero_equino.jpg")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-11-01"))
                    .empresa(empresaLaNacion)
                    .build();

            Noticia laNacionEmpresaNoticia5 = Noticia.builder()
                    .tituloNoticia("Un equipo de geólogos descubre un continente sumergido en el océano Atlántico")
                    .resumenNoticia("Investigadores de la Universidad de Harvard han anunciado el descubrimiento de un continente sumergido en el océano Atlántico, lleno de restos de antiguas civilizaciones.")
                    .imagenNoticia("https://fotografias.lasexta.com/clipping/cmsimages01/2014/03/12/E18A5598-9E94-4CB8-8F75-1F5897062C88/98.jpg?crop=800,450,x0,y41&width=1900&height=1069&optimize=high&format=webply")
                    .contenidoHtml("")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2023-12-12"))
                    .empresa(empresaLaNacion)
                    .build();


            // EMPRESA MDZ
            Empresa empresaMdz = Empresa.builder()
                    .denominacion("MDZ")
                    .telefono("+54 261 876-5432")
                    .horarioAtencion("Lunes a Viernes de 6:00 a 20:00 hs")
                    .quienesSomos("Crónica Urbana es un medio digital enfocado en noticias locales, análisis sociales y reportajes de investigación sobre la vida en las grandes ciudades.")
                    .latitud(-22.906847)
                    .longitud(-43.172897)
                    .domicilio("Av. Atlântica 1500, Río de Janeiro, Brasil")
                    .email("redaccion@cronicaurbana.com")
                    .build();

            Noticia mdzEmpresaNoticia1 = Noticia.builder()
                    .tituloNoticia("Un agujero negro descubierto cerca del sistema solar")
                    .resumenNoticia("Astrónomos han detectado un agujero negro a solo 500 años luz de la Tierra, lo que representa el hallazgo más cercano de un objeto de este tipo, con implicaciones aún desconocidas para el espacio-tiempo.")
                    .imagenNoticia("https://ciencia.nasa.gov/wp-content/uploads/sites/2/2024/05/screenshot-2024-05-09-at-4-51-54%E2%80%AFpm.png")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2025-03-18"))
                    .empresa(empresaMdz)
                    .build();

            Noticia mdzEmpresaNoticia2 = Noticia.builder()
                    .tituloNoticia("La Tierra está a punto de cambiar su órbita debido a una explosión solar masiva")
                    .resumenNoticia("Expertos en astrofísica han advertido que una explosión solar masiva podría alterar la órbita de la Tierra en los próximos años, causando un cataclismo cósmico sin precedentes.")
                    .imagenNoticia("https://content.nationalgeographic.com.es/medio/2023/12/01/tormenta-solar_c789dd10_2254730825_231201094808_1280x720.jpg")
                    .contenidoHtml("")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2025-03-18"))
                    .empresa(empresaMdz)
                    .build();

            Noticia mdzEmpresaNoticia3 = Noticia.builder()
                    .tituloNoticia("Científicos logran crear un clone de un mamut lanudo a partir de ADN congelado")
                    .resumenNoticia("Un equipo internacional de científicos ha conseguido clonar con éxito un mamut lanudo utilizando ADN recuperado de un ejemplar congelado, un avance monumental en la genética.")
                    .imagenNoticia("https://static.nationalgeographic.es/files/styles/image_3200/public/lastwrangelmammothbybethzaiken.webp?w=1600&h=1048")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2025-03-18"))
                    .empresa(empresaMdz)
                    .build();

            Noticia mdzEmpresaNoticia4 = Noticia.builder()
                    .tituloNoticia("El gobierno de Japón descubre una ciudad flotante en el Pacífico")
                    .resumenNoticia("Investigadores japoneses han encontrado una antigua ciudad flotante en el océano Pacífico, lo que plantea nuevas teorías sobre las civilizaciones perdidas del pasado.")
                    .imagenNoticia("https://japonismo.com/wp-content/uploads/2019/03/consejos-primavera-japon-japonismo.jpg")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2025-03-18"))
                    .empresa(empresaMdz)
                    .build();

            Noticia mdzEmpresaNoticia5 = Noticia.builder()
                    .tituloNoticia("En los Andes descubren una especie de dinosaurio que sobrevivió a la extinción")
                    .resumenNoticia("Paleontólogos han hallado fósiles de un dinosaurio que aparentemente sobrevivió a la extinción masiva, cambiando todo lo que sabíamos sobre el fin de la era mesozoica.")
                    .imagenNoticia("https://previews.123rf.com/images/chagpg/chagpg1603/chagpg160300265/54329095-dinosaurio-nieve-paisaje-prehist%C3%B3rico-valle-de-hielo-con-los-dinosaurios-ver-%C3%A1rtico-3d.jpg")
                    .contenidoHtml("")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2025-03-18"))
                    .empresa(empresaMdz)
                    .build();


            // EMPRESA CLARÍN
            Empresa empresaClarin = Empresa.builder()
                    .denominacion("Clarín")
                    .telefono("+54 299 432-1098")
                    .horarioAtencion("Lunes a Sábado de 7:00 a 19:00 hs")
                    .quienesSomos("La Voz Digital es un periódico en línea que informa sobre política, economía y cultura con un enfoque europeo y global, ofreciendo análisis detallados y reportajes exclusivos.")
                    .latitud(48.856613)
                    .longitud(2.352222)
                    .domicilio("15 Rue Lafayette, París, Francia")
                    .email("contacto@lavozdigital.com")
                    .build();

            Noticia clarinEmpresaNoticia1 = Noticia.builder()
                    .tituloNoticia("Científicos logran teletransportar objetos en laboratorio")
                    .resumenNoticia("Investigadores han logrado teletransportar con éxito partículas en un laboratorio, un avance histórico que podría llevar a la teletransportación de objetos en el futuro cercano.")
                    .imagenNoticia("https://cdn.businessinsider.es/sites/navi.axelspringer.es/public/media/image/2023/09/cientifico-laboratorio-3129600.jpg?tf=3840x")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-08-18"))
                    .empresa(empresaClarin)
                    .build();

            Noticia clarinEmpresaNoticia2 = Noticia.builder()
                    .tituloNoticia("Descubren un continente oculto debajo de Australia")
                    .resumenNoticia("Un grupo de geólogos ha anunciado el hallazgo de un continente oculto bajo las aguas de Australia, desafiando nuestra comprensión de la geografía terrestre.")
                    .imagenNoticia("https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iZDshdZpXIHI/v0/-1x-1.webp")
                    .contenidoHtml("")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2024-02-13"))
                    .empresa(empresaClarin)
                    .build();

            Noticia clarinEmpresaNoticia3 = Noticia.builder()
                    .tituloNoticia("Una nueva especie de tiburón gigante es descubierta en las profundidades del océano")
                    .resumenNoticia("Biólogos marinos han encontrado una especie previamente desconocida de tiburón gigante en las profundidades del océano Pacífico, lo que ha causado revuelo en la comunidad científica.")
                    .imagenNoticia("https://cdn.agenciasinc.es/var/ezwebin_site/storage/images/_aliases/img_1col/noticias/el-tiburon-gigante-megalodon-tuvo-una-zona-de-cria-en-tarragona/8450420-1-esl-MX/El-tiburon-gigante-megalodon-tuvo-una-zona-de-cria-en-Tarragona.jpg")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-05-12"))
                    .empresa(empresaClarin)
                    .build();

            Noticia clarinEmpresaNoticia4 = Noticia.builder()
                    .tituloNoticia("Una nueva teoría demuestra que la Atlántida está en el Caribe")
                    .resumenNoticia("Investigadores han propuesto una nueva teoría que sugiere que la mítica ciudad de Atlántida se encuentra sumergida en el mar Caribe, basándose en antiguos mapas y restos arqueológicos encontrados en la región.")
                    .imagenNoticia("https://static.nationalgeographic.es/files/styles/image_3200/public/gettyimages-1313288623.jpg?w=1600")
                    .contenidoHtml("")
                    .publicada(false)
                    .fechaPublicacion(sdf.parse("2024-09-29"))
                    .empresa(empresaClarin)
                    .build();

            Noticia clarinEmpresaNoticia5 = Noticia.builder()
                    .tituloNoticia("Un equipo de científicos logra revivir células de un insecto prehistórico")
                    .resumenNoticia("Un equipo internacional de biólogos ha logrado revivir células de un insecto prehistórico encontrado en ámbar, abriendo las puertas a la clonación de especies extintas.")
                    .imagenNoticia("https://chajarialdia.com.ar/wp-content/uploads/2021/05/WhatsApp-Image-2021-05-11-at-07.35.40.jpeg")
                    .contenidoHtml("")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2025-02-15"))
                    .empresa(empresaClarin)
                    .build();

            empresaRepository.saveAll(List.of(empresaElSol,empresaDiarioUno,empresaLaNacion,empresaMdz,empresaClarin));
            noticiaRepository.saveAll(List.of(empresaElSolnoticia1,empresaElSolnoticia2,empresaElSolnoticia3,empresaElSolnoticia4,empresaElSolnoticia5,diarioUnoEmpresaNoticia1,diarioUnoEmpresaNoticia2,diarioUnoEmpresaNoticia3,diarioUnoEmpresaNoticia4,diarioUnoEmpresaNoticia5,laNacionEmpresaNoticia1,laNacionEmpresaNoticia2,laNacionEmpresaNoticia3,laNacionEmpresaNoticia4,laNacionEmpresaNoticia5,mdzEmpresaNoticia1,mdzEmpresaNoticia2,mdzEmpresaNoticia3,mdzEmpresaNoticia4,mdzEmpresaNoticia5,clarinEmpresaNoticia1,clarinEmpresaNoticia2,clarinEmpresaNoticia3,clarinEmpresaNoticia4,clarinEmpresaNoticia5));
        };
    }

}
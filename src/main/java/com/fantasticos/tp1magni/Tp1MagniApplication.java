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

            // Empresa 1: El Sol (tiene 2 noticias)
            Empresa empresa1 = Empresa.builder()
                    .denominacion("El Sol")
                    .telefono("+54 11 1234-5678")
                    .horarioAtencion("Lunes a Viernes de 8:00 a 18:00 hs")
                    .quienesSomos("Somos un medio de comunicación digital comprometido con la verdad y la objetividad, brindando noticias en tiempo real sobre política, economía, tecnología y más.")
                    .latitud(-34.603722)
                    .longitud(-58.381592)
                    .domicilio("Av. Siempre Viva 742, Buenos Aires, Argentina")
                    .email("contacto@elsol.com")
                    .build();

            Noticia noticia1_1 = Noticia.builder()
                    .tituloNoticia("Descubren Ciudad Perdida Bajo el Desierto del Sahara")
                    .resumenNoticia("Arqueólogos hallan metrópolis oculta bajo las arenas del Sahara, con templos y tecnología avanzada.")
                    .imagenNoticia("https://example.com/sahara.jpg")
                    .contenidoHtml("<h1>Se ha descubierto una ciudad antigua...</h1>")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-04-30"))
                    .empresa(empresa1)
                    .build();

            Noticia noticia1_2 = Noticia.builder()
                    .tituloNoticia("Nuevo Avance en IA Revoluciona la Medicina")
                    .resumenNoticia("Un algoritmo de inteligencia artificial puede diagnosticar enfermedades con un 99% de precisión.")
                    .imagenNoticia("https://example.com/ia-medicina.jpg")
                    .contenidoHtml("<h1>Investigadores han desarrollado una IA...</h1>")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-05-10"))
                    .empresa(empresa1)
                    .build();

            // Empresa 2: TechWorld (tiene 1 noticia)
            Empresa empresa2 = Empresa.builder()
                    .denominacion("TechWorld")
                    .telefono("+54 11 9876-5432")
                    .horarioAtencion("Lunes a Sábado de 9:00 a 20:00 hs")
                    .quienesSomos("Portal de tecnología con noticias sobre IA, software, gadgets y más.")
                    .latitud(-34.599722)
                    .longitud(-58.381111)
                    .domicilio("Calle Falsa 123, Buenos Aires, Argentina")
                    .email("info@techworld.com")
                    .build();

            Noticia noticia2_1 = Noticia.builder()
                    .tituloNoticia("El Futuro de los Vehículos Autónomos")
                    .resumenNoticia("Los coches sin conductor podrían ser la norma en menos de una década.")
                    .imagenNoticia("https://example.com/autonomous.jpg")
                    .contenidoHtml("<h1>Las nuevas regulaciones impulsarán...</h1>")
                    .publicada(true)
                    .fechaPublicacion(sdf.parse("2024-06-15"))
                    .empresa(empresa2)
                    .build();

            // Empresa 3: Naturaleza Viva (sin noticias)
            Empresa empresa3 = Empresa.builder()
                    .denominacion("Naturaleza Viva")
                    .telefono("+54 11 4455-6677")
                    .horarioAtencion("Martes a Domingo de 10:00 a 18:00 hs")
                    .quienesSomos("Organización dedicada a la conservación del medio ambiente y la biodiversidad.")
                    .latitud(-34.562722)
                    .longitud(-58.412592)
                    .domicilio("Av. Ecológica 300, Buenos Aires, Argentina")
                    .email("contacto@naturalezaviva.org")
                    .build();

            // Guardar en la base de datos
            empresaRepository.saveAll(List.of(empresa1, empresa2, empresa3));
            noticiaRepository.saveAll(List.of(noticia1_1, noticia1_2, noticia2_1));
        };
    }

}
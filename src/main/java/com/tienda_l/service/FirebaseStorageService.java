package com.tienda_l.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, 
            String carpeta, 
            Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-l-1e601.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-l-1e601-firebase-adminsdk-yt6h1-92ca9a6517.json";
}

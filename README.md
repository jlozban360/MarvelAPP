# MarvelApp

MarvelApp es una aplicación de Android que permite explorar los personajes del universo Marvel utilizando la API oficial de Marvel. La app hace uso de Retrofit2 para la comunicación con la API y Jetpack Compose para construir una interfaz de usuario moderna y fluida. La app incluye funcionalidades como la visualización de detalles de los personajes, búsqueda de personajes y carga dinámica de datos.

## Características

- **Visualización de personajes de Marvel:** Muestra una lista de personajes de Marvel con sus nombres, imágenes y descripciones.
- **Búsqueda de personajes:** Permite buscar personajes de Marvel por su nombre utilizando una barra de búsqueda.
- **Pantalla de detalles:** Al seleccionar un personaje, se muestra una pantalla con detalles completos del personaje, incluyendo su descripción y una imagen ampliada.
- **Carga dinámica:** Carga más personajes cuando el usuario llega al final de la lista.
- **Interfaz de usuario moderna:** Utiliza Jetpack Compose para una experiencia de usuario moderna y fluida.
- **API de Marvel:** Consume datos de la API oficial de Marvel utilizando Retrofit2.

## Tecnologías Utilizadas

### 1. **Retrofit2**
Retrofit2 se utiliza para realizar peticiones HTTP a la API pública de Marvel y manejar la respuesta de manera eficiente. Se utiliza junto con GSON para la conversión automática de los datos JSON en objetos Kotlin.

- **Versión de Retrofit2**: 2.9.0
- **Dependencias adicionales**:
  - Gson Converter: Para convertir la respuesta JSON en objetos de Kotlin.
  - OkHttp: Para manejar las conexiones HTTP de forma eficiente.

### 2. **Jetpack Compose**
Jetpack Compose es utilizado para crear la interfaz de usuario de manera declarativa y moderna, reemplazando el tradicional sistema basado en vistas XML.

- **Versión de Jetpack Compose**: 1.3.0
- **Componentes utilizados**: `Scaffold`, `TopAppBar`, `LazyColumn`, `Button`, `Image`, entre otros.

### 3. **Coroutines**
Se utilizan Coroutines de Kotlin para manejar las operaciones asincrónicas y la obtención de datos de la API sin bloquear el hilo principal, mejorando el rendimiento y la experiencia del usuario.

- **Versión de Coroutines**: 1.7.3

### 4. **Coil**
Coil es una librería para cargar imágenes en Android de manera eficiente y sencilla. Se utiliza para cargar las imágenes de los personajes de Marvel desde la URL proporcionada por la API.

- **Versión de Coil**: 2.4.0

### 5. **Navigation Compose**
Se utiliza Navigation Compose para gestionar la navegación entre las diferentes pantallas de la aplicación de forma declarativa.

- **Versión de Navigation Compose**: 2.5.3

### 6. **Material3**
La interfaz de usuario utiliza los componentes de la librería Material3 para seguir las guías de diseño de Google y proporcionar una experiencia visualmente coherente.

- **Versión de Material3**: 1.3.1

## Requisitos

- **Android Studio 2021.1.1 o superior**
- **JDK 8 o superior**
- **Dispositivo Android o Emulador**

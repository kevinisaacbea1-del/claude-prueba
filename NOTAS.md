# Notas para Claude (contexto de Kevin)

Resumen para pegar al iniciar un chat nuevo.

## GitHub
- Usuario: `kevinisaacbea1-del`
- GitHub vinculado a claude.ai y app de Claude instalada con permiso de escritura.
- Repos:
  - `claude-prueba` (publico): app Android "Contador" + workflow de GitHub Actions.
  - `claude-android` (privado): para apps Android.
  - `claude-windows` (privado): para programas de Windows (.exe).

## Flujo de trabajo
1. Claude escribe el codigo y lo sube a `main`.
2. GitHub Actions compila y publica el APK o .exe en *Releases* (enlace de descarga directo).
3. Ejemplo que ya funciono: `build-1` de `claude-prueba` (Contador.apk).

## Limitaciones conocidas
- Claude no puede crear repos: los crea Kevin y luego se conectan con `usuario/repo`.
- El entorno de Claude no tiene el SDK de Android ni acceso a `dl.google.com`: por eso se compila en GitHub Actions.
- La app bloquea descargar .exe directo en el chat: se manda en .zip o se baja desde Releases.
- Actions en repos privados: 2,000 min/mes gratis; los runners de Windows cuentan doble.

## Sobre Kevin
- Tiene PC con Windows, no tiene celular.
- Plan gratuito de Claude. Prefiere chats cortos por proyecto.
- Ideas pendientes con ventana en Windows: generador de contrasenas, organizador de Descargas, contador.

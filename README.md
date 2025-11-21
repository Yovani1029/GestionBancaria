#Gestión de Cuentas Bancarias

## Descripción
Este proyecto implementa un sistema básico de gestión de cuentas bancarias en Java. Incluye funcionalidades de:
- Registro de usuarios
- Creación de cuentas
- Depósitos, retiros y transferencias
- Validaciones de datos (teléfonos, saldo, existencia de cuenta)

El proyecto cuenta con un pipeline de CI/CD que realiza:
- Lenguaje: Java 21
- Linter (Checkstyle)
- Compilación con Maven
- Pruebas unitarias (JUnit 5)
- Reporte de cobertura (JaCoCo)
- Validación de cobertura mínima (80%)

---

## Ejecución del pipeline en GitHub Actions
El workflow se encuentra en `.github/workflows/ci-quality.yml` y se activa en:
- `push`
- `pull_request`

### Pasos del pipeline:
1. Checkout del código
2. Configuración de JDK 21
3. Instalación de dependencias y compilación
4. Ejecución de linter (Checkstyle)
5. Ejecución de pruebas unitarias (JUnit 5)
6. Generación de reporte de cobertura (JaCoCo)
7. Validación de cobertura mínima (80%)
8. Finalización exitosa si todo pasó
- **Nota:** Si algún paso falla, el workflow se detiene y marca el job como fallido.


### Ejecución local con `act`
**¿Qué es `act`?**  
`act` permite ejecutar los workflows de GitHub Actions **localmente** usando Docker, simulando los runners de GitHub.
**Requisitos:**
- Docker instalado y corriendo.
- `act` instalado (puede instalarse con Chocolatey en Windows: `choco install act`).
- Verificar instalación: `act --version`.


Comando para ejecutar el pipeline localmente:

```bash
  act -j build-test 
```


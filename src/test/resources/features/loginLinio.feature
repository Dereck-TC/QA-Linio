@Linio
Feature: Linio

  @LoginLinio
  Scenario Outline: Login verificado de un usuario
    Given que estoy en la URL "https://www.linio.com.pe/account/login"
    When ingreso el E-mail "<E-MAIL>"
    And tipeo la clave "<CLAVE>"
    Then doy clic en iniciar sesión
    Then valido que el usuario "<USER_NAME>" esté logueado

    Examples:
    |E-MAIL             |CLAVE        |USER_NAME|
    |jackluan@gmail.com |Linio08.com% |jack     |
  
  @CarritoLinio
  Scenario: Agregando un producto al carrito de compras
    Given que estoy en la URL "https://www.linio.com.pe/"
    And selecciono la opcion de Promos y cupones
    When elijo el producto
    And valido que el producto sea "Laptop Gamer Asus"
    Then agrego al carrito
    And valido que salga el mensaje "Tu producto se agregó al carrito"




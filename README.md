# Examen PMDM


## Diagrama de estados

```mermaid
stateDiagram-v2
    [*] --> Idle

    Idle --> MovingUP: pulsar boton arriba
    MovingUP --> Idle: abrir puerta

    Idle --> MovingDOWN: pulsar boton abajo
    MovingDOWN --> Idle: abrir puerta

    Idle --> Error: fallo
    MovingUP --> Error: fallo
    MovingDOWN --> Error: fallo
    Error --> Error: fallo


```

En mi programa tengo 4 estados

![img.png](img.png)

4 posiciones donde puede estar el ascensor

![img_1.png](img_1.png)

4 metodos

![img_2.png](img_2.png)

este metodo comprueba que al pulsar el boton de bajar si esta en la poscion Pcompostela si esta ahi, el ascensor baja y pasa a posicion movimiento

![img_3.png](img_3.png)

este metodo comprueba que al pulsar el boton de subir si esta en la poscion GarciaBarbon si esta ahi, el ascensor sube y pasa a posicion movimiento

![img_4.png](img_4.png)

este metodo registra si se esta moviendo el ascensor, cuando llega abre las puesta y pasa a estado idle y cambia la posicion a la que es

![img_5.png](img_5.png)
![img_6.png](img_6.png)

registra el error y cambia el estado y posicion a error

![img_7.png](img_7.png)
comprobacion de que los test funcionan

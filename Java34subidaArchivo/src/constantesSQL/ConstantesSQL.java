package constantesSQL;

public class ConstantesSQL {
public static final String SQL_INSERCION_PRODUCTOS = 
"insert into tabla_productos(nombre, precio) " + "values(?,?)";
public static final String SQL_SELECION_PRODUCTOS = "select * from tabla_productos";

}

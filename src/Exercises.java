import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
public class Exercises {

    private void accessControl(){
//        Implementa el control de acceso para una empresa de seguridad información . Se debe pedir
//        un nombre de usuario y una contraseña. Si el usuario introduce los datos correctamente, el
//        programa dirá "Ha accedido aceptado". El usuario tendrá un máximo de 4 oportunidades. Si se
//        agotan las oportunidades el programa dirá "Lo siento, no tiene acceso al área restringida". Los
//        nombres de usuario con sus correspondientes contraseñas que son permitidas deben estar
//        almacenados en una estructura de la clase HasMap
        HashMap<String, String> usuarios = new HashMap<>();
        usuarios.put("usuario1", "password1");
        usuarios.put("usuario2", "password2");
        usuarios.put("usuario3", "password3");

        Scanner scanner = new Scanner(System.in);
        int intentos = 4;

        while (intentos > 0) {
            System.out.print("Ingrese su nombre de usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String contrasenia = scanner.nextLine();

            if (usuarios.containsKey(usuario) && usuarios.get(usuario).equals(contrasenia)) {
                System.out.println("Acceso aceptado.");
                break;
            } else {
                System.out.println("Usuario o contraseña incorrectos. Le quedan " + --intentos + " intentos.");
            }
        }

        if (intentos == 0) {
            System.out.println("Lo siento, no tiene acceso al área restringida.");
        }

        scanner.close();
    }
    public static int findMaxDifference(int[] arr) {
       /* La diferencia de un par de elementos en el array a esta definida como a[j] – a[i] donde i < j y
        a[i]< a[j]
        Complete el método maximaDiferencia que recibirá un array a de enteros y calculara la
        máxima diferencia para ese array.
                Si no puede calcular la máxima diferencia (por ejemplo, si a esta en orden descante) retornar -1*/
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int min = arr[0];
        int maxDiff = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min > maxDiff && arr[i] > min) {
                maxDiff = arr[i] - min;
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return maxDiff;
    }


    public static boolean hasTwoSum(int[] nums, int target) {
/*        Dada una lista A de N enteros y un numero K, determinar si existe un par de elementos en la
        lista cuta suma de exactamente K.
        Por ejemplo, dado la lista {1, 3, 7} y k=8, la respuesta es “SI”, pero dada K=6 la respuesta es
”NO”*/

        // Crear una tabla hash vacía

        Map<Integer, Integer> numMap = new HashMap<>();

        // Insertar cada elemento de la lista nums en la tabla hash
        for (int num : nums) {
            numMap.put(num, num);
        }

        // Buscar si existe un par de elementos cuya suma es target
        for (int num : nums) {
            int complement = target - num;
            if (numMap.containsKey(complement) && numMap.get(complement) != num) {
                return true;
            }
        }

        // Si no se encontró un par de elementos cuya suma es target, retornar false
        return false;
    }


    public static void main(String[] args) {
    //  Exercises exercises = new Exercises();
    //  exercises.accessControl();

        // int[] arr = {1, 3, 5, 7, 10};
          //int maxDiff = findMaxDifference(arr);
         //System.out.println("La mayor diferencia en el array es: " + maxDiff);

        int[] nums = {1, 3, 7};
        int target1 = 8;
        int target2 = 6;

        System.out.println( hasTwoSum(nums, target1));
        System.out.println( hasTwoSum(nums, target2));

    }
}
package ejercicioRepasoLambda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class expreg {
public static void main(String[] args) {
/* PROGRAMA HECHO EN PERL equivalente
$_=�Para todo x: |x|=|-x|�;
print �[$`]\n[$&]\n[$�]\n� if /x/; # imprime [Para todo ]
# [x]
# [: |x|=|-x|]
print �[$&]\n� if m/todo/; # imprime [todo]
$e=�la menor: la si do re mi fa(#) sol(#) la�;
print �[$&]\n� if $e=~/\(#\)/; # imprime [(#)]
*/
Pattern pat=null;
Matcher mat=null;
String texto="Para todo x: |x|=|-x|";
pat=Pattern.compile("x");
mat=pat.matcher(texto);
System.out.println("Texto �> "+texto);
if(mat.find()){
System.out.println("\tExpresion regular �> /x/");
System.out.println("\t["+texto.substring(0,mat.start())+"]");
System.out.println("\t["+mat.group()+"]");
System.out.println("\t["+texto.substring(mat.end(),texto.length())+"]");
}/*
pat=Pattern.compile(�todo�);
mat=pat.matcher(texto);
if(mat.find()){
System.out.println(�\n\tExpresion regular �> /todo/�);
System.out.println(�\t[�+mat.group()+�]�);
}
texto=�la menor: la si do re mi fa(#) sol(#) la�;
pat=Pattern.compile(�\\(#\\)�);
mat=pat.matcher(texto);
System.out.println(�\n\nTexto �> �+texto);
if(mat.find()){
System.out.println(�\tExpresion regular �> /\\(#\\)/�);
System.out.println(�\t[�+mat.group()+�]�);
}*/
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author FARAMBURA
 */
public class NodoDoble <T>{
   private NodoDoble<T> der,izq;
   private T dato;

   public NodoDoble() {
       der = null;
       izq = null;
   }

   public NodoDoble(T dato){
       this();
       this.dato= dato;
   }

   public NodoDoble<T> getDer() {
       return der;
   }

   public void setDer(NodoDoble<T> der) {
       this.der = der;
   }

   public NodoDoble<T> getIzq() {
       return izq;
   }

   public void setIzq(NodoDoble<T> izq) {
       this.izq = izq;
   }

   public T getDato() {
       return dato;
   }

   public void setDato(T dato) {
       this.dato = dato;
   }

   @Override
   public String toString() {
       return "NodoDoble{" + "dato=" + dato + '}';
   }




}
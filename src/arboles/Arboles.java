/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;
import static javafx.scene.input.KeyCode.T;
/**
 *
 * @author FARAMBURA
 */
public class Arboles<T> {
    
    NodoDoble<Integer> raiz;
    
    public Arboles(NodoDoble<Integer> apNodo) {
        raiz = apNodo;
    }
    
    public NodoDoble<Integer> getRaiz() {
        return raiz;
    }
    
    public boolean busca1(int dato){
        return busca(raiz,dato);
    }
    
    public  boolean busca(NodoDoble<Integer> ap, int dato){
        if(ap != null){
            if(dato<ap.getDato()){
                return busca(ap.getIzq(),dato);
            }
            else if(dato>ap.getDato()){
                return busca(ap.getDer(),dato);
            }
            else{
                return true;
            }
        }
        else
            return false;
    }
    
    public boolean inserta(int dato){
        if(raiz!=null){
            return ins(raiz,dato);
        }
        else{
            raiz=new NodoDoble(dato);
            return true;
        }
    }
    
    public boolean ins(NodoDoble<Integer> ap, int dato){
        NodoDoble<Integer> otro;
        if(ap.getDato()==dato){
            return false;
        }
        else if(dato<ap.getDato()){
            if(ap.getIzq()==null){
                otro = new NodoDoble(dato);
                ap.setIzq(otro);
                return true;
            }
            else
               return  ins(ap.getIzq(),dato);
        }
        else if(dato>ap.getDato()){
            if(ap.getDer()==null){
                otro = new NodoDoble(dato);
                ap.setDer(otro);
                return true;
            }
            else
                return ins(ap.getDer(),dato);
        }
        else
            return false;
    }
    
    public boolean elimina(int dato){
        if(raiz.getDato()==dato){
           if(raiz.getIzq()!=null){
            NodoDoble<Integer> otro = raiz.getIzq();
            NodoDoble<Integer> aux = otro;
            while(otro.getDer()!=null){
                aux=otro;
                otro = otro.getDer();
            }
            if(otro.getIzq()!=null){
                aux.setDer(otro.getIzq());
            }
            otro.setDer(raiz.getDer());
            otro.setIzq(raiz.getIzq());
            raiz.setDer(null);
            raiz.setIzq(null);
            raiz = otro;
            return true;
           }
           else{
               raiz = raiz.getDer();
               return true;
           }
        }
        if(dato>raiz.getDato())
            return elim(raiz, raiz.getDer(), dato);
        else
            return elim(raiz,raiz.getIzq(),dato);
    }
    
    private boolean elim(NodoDoble<Integer> ap, NodoDoble<Integer> apaux, int dato){
        NodoDoble<Integer> otro;
        NodoDoble<Integer> otro2;
        NodoDoble<Integer> otro3;
        if(apaux != null){
            if(dato<apaux.getDato()){
                ap=apaux;
                return elim(ap, apaux.getIzq(), dato);
            }
            else if(dato>apaux.getDato()){
                ap = apaux;
                return elim(ap, apaux.getDer(), dato);
            }
            else{
                otro = apaux;
                if(ap.getIzq().getDato()==dato){
                    if(apaux.getIzq()==null){
                        ap.setIzq(apaux.getDer());
                        apaux.setDer(null);
                        apaux.setIzq(null);
                        apaux=null;
                        return true;
                    }
                    else{
                        otro2 = apaux.getIzq();
                        otro3=otro2;
                        if(otro2.getDer() != null){
                            while(otro2.getDer()!= null){
                                otro3=otro2;
                                otro2=otro2.getDer();
                            }
                            ap.setIzq(otro2);
                            otro3.setDer(null);
                            otro2.setIzq(apaux.getIzq());
                            otro2.setDer(apaux.getDer());
                            apaux.setDer(null);
                            apaux.setIzq(null);
                            apaux=null;
                        }
                        else{
                            ap.setIzq(otro2);
                            apaux.setIzq(null);
                            otro2.setDer(apaux.getDer());
                            apaux.setDer(null);
                            apaux=null;
                        }
                    }
                }
                else{
                    if(apaux.getIzq()==null){
                        ap.setDer(apaux.getDer());
                        apaux.setDer(null);
                        apaux.setIzq(null);
                        apaux=null;
                        return true;
                    }
                    else{
                        otro2 = apaux.getIzq();
                        otro3=otro2;
                        if(otro2.getDer() != null){
                            while(otro2.getDer()!= null){
                                otro3=otro2;
                                otro2=otro2.getDer();
                            }
                            ap.setDer(otro2);
                            otro3.setDer(null);
                            otro2.setIzq(apaux.getIzq());
                            otro2.setDer(apaux.getDer());
                            apaux.setDer(null);
                            apaux.setIzq(null);
                            apaux=null;
                        }
                        else{
                            ap.setDer(otro2);
                            apaux.setIzq(null);
                            otro2.setDer(apaux.getDer());
                            apaux.setDer(null);
                            apaux=null;
                        }
                    }
                }
            }
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    NodoDoble<Integer> q = new NodoDoble(50);
    NodoDoble<Integer> q1 = new NodoDoble(55);
    NodoDoble<Integer> q2 = new NodoDoble(45);
    NodoDoble<Integer> q3 = new NodoDoble(46);
    NodoDoble<Integer> q4 = new NodoDoble(70);
    NodoDoble<Integer> q5 = new NodoDoble(53);
    q.setDer(q1);
    q.setIzq(q2);
    q2.setDer(q3);
    q1.setDer(q4);
    q1.setIzq(q5);
    Arboles a = new Arboles(q);
    
        //System.out.println(a.inserta(40));
        //System.out.println(a.busca1(40));
        //System.out.println(a.getRaiz().getIzq().getDer().getDato());
        
        int x = 55;
        System.out.println(a.busca1(x));
        System.out.println(a.elimina(x));
        System.out.println(a.busca1(x));
        System.out.println(a.busca1(45));
        System.out.println(a.busca1(50));
        System.out.println(a.busca1(46));
        System.out.println(a.busca1(70));
        System.out.println(a.busca1(53));
    }
}

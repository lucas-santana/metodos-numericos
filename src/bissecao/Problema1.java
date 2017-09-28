/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package bissecao;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 *
 * @author Lucas
 */
public class Problema1 {
    
    public static void main(String[] args) throws IOException {
        //int k =(int) (((log((2.0-1.5)/pow(10,-5)))/log(2))-1);
	int k = 0;
        double a=1.5,b=2.0;
        double a2=1.5,b2=2.0;//valores iniciais da falsa posição
        
	double x=0,x2=0,xn=0,xs=0;
        double erro =0;
        double fx,fx2,fx3;
        
        double kn=0,chute1=0,chute2=0;
        /*FileWriter arq = new FileWriter("C:\\Users\\Richard\\Google Drive\\CEFET\\6-Período 2017-2\\Metodos Computacionais\\aula 12-09\\arquivo1.txt");
        FileWriter arq2 = new FileWriter("C:\\Users\\Richard\\Google Drive\\CEFET\\6-Período 2017-2\\Metodos Computacionais\\aula 12-09\\arquivo2.txt");
        FileWriter arq3 = new FileWriter("C:\\Users\\Richard\\Google Drive\\CEFET\\6-Período 2017-2\\Metodos Computacionais\\aula 12-09\\arquivo3.txt");*/
        
        FileWriter arq =  new FileWriter("E:\\p1bis.txt");
        FileWriter arq2 = new FileWriter("E:\\p1fal.txt");
        //FileWriter arq3 = new FileWriter("E:\\p1new.txt");
        FileWriter arq4 = new FileWriter("E:\\p1sec.txt");
        
        PrintWriter gravarArq = new PrintWriter(arq);
        PrintWriter gravarArq2 = new PrintWriter(arq2);
        //PrintWriter gravarArq3 = new PrintWriter(arq3);
        PrintWriter gravarArq4 = new PrintWriter(arq4);
 
         //gravarArq.printf("+--Resultado--+%n");
         //System.out.println("iterações "+k);
         
        //metodo da bisseçao 
        k=0;
        a=0;
        b=0.125664;
        x=0;
	while(k<100 && f(x)>0.001){
	
		x = (a+b)/2;
		if(f(a)*f(x)<0){//faz a troca
			b=x;
		}else{
			a = x;
		}
                fx = f(x);
                
                
                //kn chute da bisseção
            	if(k==0){//pega a primeira raiz encontrada pela bisseção para usar no metodo da secante
                    chute1 = x;
                }
                if(fx>0.0){
                    gravarArq.printf("%d\t%.20f%n",k+1,fx);
                }
		k++;
	}
        
        //metodo da Falsa Posição
        k=0;
        a2=0;
        b2=0.125664;
        x2 = 0;
        while(k<100 && f(x2)>0.001){
		
		x2 = (a2*f(b2)-b2*f(a2))/(f(b2)-f(a2));
		if(f(a2)*f(x2)<0){
			b2=x2;
		}else{
			a2 = x2;
		}
                fx2 = abs(f(x2));
                
                
                if(k==0){
                    chute2 = x2;
                }
                if(fx2>0.0){
                    gravarArq2.printf("%d\t%.20f%n",k+1,fx2);
                }
		k++;
	}
        
        //metodo de Newton
//        k=0;
//        kn = chute1;
//        while(k<100){
//		
//		xn=kn-(f(kn)/flinha(kn));
//                fx3 = abs(f(xn));
//                gravarArq3.printf("%d\t%.20f%n",k+1,fx3);
//                kn=xn;
//		k++;
//	}
        
        
        
       k = 2;
             
       
       double ks0 = chute1;
       double ks1 = chute2;
       xs = 0;
       
       gravarArq4.printf("%d\t%.20f%n",k-1,abs(f(ks0)));
       gravarArq4.printf("%d\t%.20f%n",k,abs(f(ks1)));
       double teste;
       while (k<100 && f(xs)>0.001){
           teste = (f(ks1)-f(ks0));
           if(teste!=0){
               //System.out.println("ZERO: "+(f(ks1)-f(ks0)));               
               
                xs = (ks0*f(ks1)-ks1*f(ks0))/(f(ks1)-f(ks0));
                ks0 = ks1;
                ks1 = xs;
                gravarArq4.printf("%d\t%.20f%n",k+1,abs(f(xs)));
                k++;     
           }else{
               gravarArq4.printf("%d\t%.20f%n",k+1,teste);
               k++;
           }
           
              
           
           //System.out.println("Valor da Raiz Metodo da Secante: "+xs+" - "+k);
           
       }
       
       
       
       
        System.out.println("Valor da Raiz Metodo da Bisseção: "+x);
        System.out.println("Valor da Raiz Metodo da Falsa Posição: "+x2);
        //System.out.println("Valor da Raiz Metodo de Newton: "+xn);
        System.out.println("Valor da Raiz Metodo da Secante: "+xs);
        
        
        
        
         arq.close();
         arq2.close();
         //arq3.close();
         arq4.close();
    }
    
     public static double f(double x){
	double resultado;
	//resultado = pow(x/2,2)-sin(x);
        
        resultado = ((Math.PI*0.8*(pow((300/Math.cos(x)),2)))/((Math.PI*98)*(1+Math.sin(x)-0.5*Math.cos(x))))-1200;
	
	return resultado;
        
}
    
     public static double flinha(double x){
        double resultado;
        resultado=(x/2)-cos(x);
        return resultado;
    }
    
    
}

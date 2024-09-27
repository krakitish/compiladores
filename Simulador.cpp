#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <stdlib.h>

using namespace std;

void SimAFD(int Q, int E, int S, int q, int F, int cv);
vector<int> convEnteros(const string& input);

struct regla
{
    int inicial;
    int alfaEnetrada;
    int final;
};


class Nodo
{
public:
    int nombre;
    bool inicial;
    bool final;
    vector<regla> reglas;

    Nodo(int n,bool i,bool f){
        nombre=n;
        inicial=i;
        final=f;
    }

    int tran(int e){
        for (int i = 0; i < reglas.size()+1; i++)
        {
            if(reglas[i].alfaEnetrada==e){
                return reglas[i].final;
            }
            
        }
           return nombre;
    }

    void agregar(regla r){
        reglas.push_back(r);
    }
};



int main(){

    
    string descripcion;
    std::cout<<"ENTRADA LA DESCRIPCION"<<endl;
    getline(cin,descripcion);
    
    vector<int> tupla=convEnteros(descripcion);
    int Q=tupla[0];
    int E=tupla[1]; 
    int S=tupla[2];
    int q=tupla[3];
    int F=tupla[4];
    int cv=tupla[5];
   
    SimAFD(Q,E,S,q,F,cv);
    
    return 0;
    
}

void SimAFD(int Q, int E, int S, int q, int F, int cv){

    vector<int> alfabeto;
    vector<string> funTran;
    vector<int> aceptacion;
    vector<string> transPrueba;
    vector<Nodo> Estados;
std::cout<<"ENTRADA DE ALFABETO"<<endl;        
        string aux;
        cin>>aux;
        alfabeto=convEnteros(aux);
   
    std::cout<<"ESTADOS DE ACCEPTACION"<<endl;
    for (int i = 0; i < F; i++)
    {
        
        int aux;
        cin>>aux;
        aceptacion.push_back(aux);
    } 
    std::cout<<"FUNCIONES DE TRANSICION"<<endl;
    cin.ignore();
    for (int i = 0; i < S; i++)
    {
        
        string aux;
    
        getline(cin,aux);
        funTran.push_back(aux);
    } 
    
    for (int i = 0; i < Q; i++)
    {   

        bool iniclial=false;
        bool final=false;
        if(q==i+1){
            iniclial=true;
        }
        for (int j = 0; j < aceptacion.size()+1; j++)
        {

           if(i+1==aceptacion[j]){
            final=true;
            break;
            }
        }
        
        Nodo n(i+1,iniclial,final);
        Estados.push_back(n);
    }
    
    for (int i = 0; i < S; i++)
    {
        vector<int> numeros=convEnteros(funTran[i]);
       for (int j = 0; j < Q; j++)
       {
         if ( Estados[j].nombre==numeros[0])
         {
            regla r;
            r.inicial=numeros[0];
            r.alfaEnetrada=numeros[1];
            r.final=numeros[2];
            Estados[j].agregar(r);

         }
        
       }
       
       
    }
    std::cout<<"TRANSICIONES DE PRUEBA"<<endl;
    for (int i = 0; i < cv; i++)
    {
        string aux;
        cin>>aux;
        transPrueba.push_back(aux);
    } 
    

    for (int i = 0; i < cv; i++)
    {
        int l;
       for (l = 0; l < Estados.size(); l++)
       {
        if (Estados[l].inicial==true)
        {
            break;
        }
       }
       
       
       vector<int> prueba=convEnteros(transPrueba[i]);

        int tranSiguiente;
       for (int j = 0; j < prueba.size(); j++)
       {
       
       tranSiguiente=Estados[l].tran(prueba[j]);

       l=tranSiguiente-1;
       }

       if (Estados[l].final==true)
       {
        std::cout<<"ACEPTADA"<<endl;
       }else{
        std::cout<<"RECHAZADA"<<endl;

       }
       
    }
    
    
}

vector<int> convEnteros(const string& entrada) {
    vector<int> numeros;

    
    for (char c : entrada) {
        if (isdigit(c)) {
            numeros.push_back(c - '0');
        }
    }

    return numeros;
}
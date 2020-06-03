package com.sap.b1.consoletest.generics;

/**
 * Hello world!
 *
 */
public class GenericPracticeMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        GenericData<String> stringData = new GenericData<String>("aa");
        System.out.println(stringData.getKey());
        
        GenericData<Integer> integerData = new GenericData<Integer>(2);
        int a = integerData.getKey();
        System.out.println(a);
        
        ShowKeyValue(stringData);
        ShowKeyValue(integerData);
        
        Class clazzS = stringData.getClass();
        Class clazzI = integerData.getClass();
        
        if(clazzS.equals(clazzI))
        {
        	System.out.println( clazzS.getName() + " and "  + clazzI.getName() + " two class Equal");
        }
       
        Generator<String> gen = new ItemGenerator<String>("bb");
        System.out.println(gen.doSthing());
        System.out.println(gen.getClass().getName());
        
        printMsg(stringData, integerData, clazzS, clazzI);
    }
    //
    private static void ShowKeyValue(GenericData<?> data)
    {
    	System.out.println(data.getKey());
    }
    
    public static <T> void printMsg( T... args){
        for(T t : args){
        	System.out.println("泛型测试   + t is " + t);
        }
    }
}

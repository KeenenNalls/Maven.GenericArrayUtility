package com.zipcodewilmington.arrayutility;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] inputArray;
    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] newArray = mergeArray(arrayToMerge);
        int counter = 0;
        for (T t : newArray){
            if (t.equals(valueToEvaluate)){
                counter++;
            }
        }
        return counter;
    }


         //return null;
    private T[] mergeArray(T[] arrayToMerge) {
        T[] newArray = Arrays.copyOf(inputArray, inputArray.length+arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, newArray,inputArray.length,arrayToMerge.length);
        return newArray;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        //return null;
        T[]  newArray = mergeArray(arrayToMerge);
        int maxInt = -1;
        T thing = null;
        for (T t: newArray){
            if (getNumberOfOccurrences(t)>maxInt){
                maxInt = getNumberOfOccurrences(t);
                thing = t;
            }
        }


        return thing;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int numOfOcc = 0;
        for (T t : inputArray) {
            if (t.equals(valueToEvaluate)) {
                numOfOcc++;
            }
        }
        return numOfOcc;
    }
    public T[] removeValue(T valueToRemove) {
        int counter = 0;
        T[] newArray = (T[]) Array.newInstance(valueToRemove.getClass(), inputArray.length - getNumberOfOccurrences(valueToRemove));
        for (T thing : inputArray) {
            if (!thing.equals(valueToRemove)) {
                newArray[counter] = thing;
                counter++;
            }
        }
        return newArray;
    }
}

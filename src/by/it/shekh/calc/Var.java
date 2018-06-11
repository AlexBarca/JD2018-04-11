package by.it.shekh.calc;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String key, Var var) {
        vars.put(key, var);
        return var;
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна\n");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна\n");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна\n");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна\n");
    }


    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return vars.get(strVar);
        throw new CalcException("Ошибка обработки:" + strVar);
    }
}

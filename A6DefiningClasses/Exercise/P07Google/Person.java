package A6DefiningClasses.Exercise.P07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = new ArrayList<>();
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = new ArrayList<>();
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = new ArrayList<>();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company);
        }
        sb.append("Car:").append(System.lineSeparator());
        if (car != null) {
            sb.append(car).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : this.pokemons) {
            sb.append(pokemon).append(System.lineSeparator());
        }
        sb.append("Parents:").append(System.lineSeparator());
        for (Parent parent : this.parents) {
            sb.append(parent).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for (Child child : this.children) {
            sb.append(child).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

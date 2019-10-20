package hw07;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    Family(Human mother, Human father) {
        this.mother = mother;
        mother.setFamily(this);
        this.father = father;
        father.setFamily(this);
        this.children = new Human[0];
    }

    Human getMother() {
        return mother;
    }

    Human getFather() {
        return father;
    }

    Pet getPet() {
        return pet;
    }

    void setPet(Pet pet) {
        this.pet = pet;
    }

    int countFamily() {
        return children.length + 2;
    }

    void addChild(Human child) {
        child.setFamily(this);
        Human[] newChildren = new Human[children.length + 1];

        System.arraycopy(children, 0, newChildren, 0, children.length);
        newChildren[children.length] = child;
        children = newChildren;
    }

    boolean deleteChild(int i) {
        if(i < 0 || i >= children.length) {
            return false;
        } else {
            children[i].setFamily(null);
            Human[] newChildren = new Human[children.length - 1];

            if(i > 0) {
                System.arraycopy(children, 0, newChildren, 0, i);
            }
            if(i < children.length - 1) {
                System.arraycopy(children, i + 1, newChildren, i, children.length - 1 - i);
            }
            children = newChildren;
            return true;
        }
    }

    boolean deleteChild(Human child) {
        for(int i = 0; i < children.length; i++) {
            if(child.hashCode() == children[i].hashCode() && child.equals(children[i])) {
                return deleteChild(i);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Family{" +
                "\n    mother=" + mother +
                ",\n    father=" + father +
                ",\n    children=" + Arrays.toString(children) +
                ",\n    pet=" + pet + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Family family = (Family) o;

        if (!mother.equals(family.mother)) return false;
        return father.equals(family.father);
    }

    @Override
    public int hashCode() {
        int result = mother.hashCode();
        result = 31 * result + father.hashCode();
        return result;
    }
}

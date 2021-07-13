package entity;

import java.util.ArrayList;

public class Term {
    private int id;
    private String name;
    private String duration;
    private int status = 1;
    private ArrayList<Discipline> disciplines = new ArrayList<Discipline>();

    public Term() {
    }

    public Term(int id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;

        Term term = (Term) o;

        if (getId() != term.getId()) return false;
        if (getStatus() != term.getStatus()) return false;
        if (getName() != null ? !getName().equals(term.getName()) : term.getName() != null) return false;
        if (getDuration() != null ? !getDuration().equals(term.getDuration()) : term.getDuration() != null)
            return false;
        return getDisciplines() != null ? getDisciplines().equals(term.getDisciplines()) : term.getDisciplines() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
        result = 31 * result + getStatus();
        result = 31 * result + (getDisciplines() != null ? getDisciplines().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disciplines=" + disciplines +
                '}';
    }
}

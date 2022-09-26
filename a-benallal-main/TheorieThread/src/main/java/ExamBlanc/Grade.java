package ExamBlanc;

/**
 *
 * @author anasbenallal
 */
public class Grade implements Comparable<Integer> {

    private Integer Data;

    public Grade(Integer Data) {
        this.Data = Data;
    }

    @Override
    public Integer compareTo(Integer other) {
        return 0;
    }

}

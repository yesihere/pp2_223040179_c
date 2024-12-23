import model.MyBatisUtil;
import model.ClothingMapper;
import org.apache.ibatis.session.SqlSession;
import view.ClothingView;
import controller.ClothingController;

public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        ClothingMapper mapper = session.getMapper(ClothingMapper.class);

        ClothingView view = new ClothingView();
        new ClothingController(view, mapper, session);

        view.setVisible(true);
    }
}
package sudoku.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import sudoku.Difficulty;
import sudoku.handlers.GameDao;
import sudoku.handlers.GameDaoImpl;
import sudoku.models.Game;
import sudoku.models.GameFactory;

/**
 *
 * @author Waldo
 */
public class DBImport {
    public static void initData() throws Exception {
        GameDao gh = new GameDaoImpl();
        
        List<int[]> preDokus = new ArrayList();

        int[] doku1 = { 8,3,7,1,9,5,6,4,2,9,6,5,8,4,2,1,7,3,1,4,2,7,3,6,5,9,8,3,5,6,4,1,8,9,2,7,7,1,4,6,2,9,8,3,5,2,9,8,3,5,7,4,1,6,4,2,9,5,6,3,7,8,1,6,7,1,2,8,4,3,5,9,5,8,3,9,7,1,2,6,4 };
        int[] doku2 = { 3,9,1,4,5,7,8,6,2,8,6,4,2,9,1,7,5,3,5,2,7,8,6,3,1,4,9,4,1,8,7,3,9,5,2,6,9,5,6,1,2,4,3,8,7,7,3,2,5,8,6,4,9,1,6,4,9,3,7,8,2,1,5,2,8,3,6,1,5,9,7,4,1,7,5,9,4,2,6,3,8 };
        int[] doku3 = { 2,3,5,9,4,6,8,1,7,4,1,8,7,5,3,2,9,6,7,6,9,8,2,1,3,4,5,6,5,2,3,9,4,1,7,8,1,9,4,5,8,7,6,2,3,3,8,7,6,1,2,4,5,9,9,2,6,4,7,8,5,3,1,5,4,3,1,6,9,7,8,2,8,7,1,2,3,5,9,6,4 };
        int[] doku4 = { 7,2,1,3,4,8,9,6,5,6,5,9,2,7,1,3,4,8,3,4,8,9,5,6,2,7,1,4,8,6,1,2,7,5,9,3,9,7,5,8,3,4,1,2,6,1,3,2,5,6,9,4,8,7,2,6,4,7,1,5,8,3,9,8,1,3,6,9,2,7,5,4,5,9,7,4,8,3,6,1,2 };
        int[] doku5 = { 6,1,3,7,5,8,2,9,4,4,8,2,3,6,9,5,1,7,5,9,7,2,1,4,6,8,3,1,6,9,8,7,5,3,4,2,2,3,5,4,9,6,8,7,1,7,4,8,1,3,2,9,6,5,8,7,4,6,2,3,1,5,9,9,2,6,5,4,1,7,3,8,3,5,1,9,8,7,4,2,6 };
        
        Game g1 = GameFactory.create(Difficulty.Hard);
        for(int i : doku1)
        {
            
        }
        
        Game g2 = GameFactory.create(Difficulty.Hard);
        Game g3 = GameFactory.create(Difficulty.Hard);
        Game g4 = GameFactory.create(Difficulty.Hard);
        Game g5 = GameFactory.create(Difficulty.Hard);

        gh.addGame(g1);
        gh.addGame(g2);
        gh.addGame(g3);
        gh.addGame(g4);
        gh.addGame(g5);
    }
}

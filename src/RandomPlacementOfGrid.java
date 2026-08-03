import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomPlacementOfGrid
{
    private static int rowsUserStr;
    private static int columnsUserStr;
    private static int extraUserStr;
    public static void main(String args[]){
        JFrame frame = new JFrame("Random Placement of an Object on a Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        ImageIcon image = new ImageIcon("icon.png");
        frame.setIconImage(image.getImage());
        frame.setResizable(false);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(new Color(32,32,32));
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel){
        panel.setLayout(null);

        JLabel rowsLabel = new JLabel("How many rows are there?");
        rowsLabel.setForeground(Color.white);
        rowsLabel.setBounds(10, 20, 300, 25);
        panel.add(rowsLabel);

        JTextField rowsText = new JTextField();
        rowsText.setForeground(Color.black);
        rowsText.setBounds(10, 50, 100, 25);
        panel.add(rowsText);

        JButton rowsSubmitButton = new JButton("Submit");
        rowsSubmitButton.setBackground(new Color(69,69,69));
        rowsSubmitButton.setForeground(new Color(255,255,255));
        rowsSubmitButton.setBounds(10, 80, 80, 25);
        panel.add(rowsSubmitButton);

        JLabel columnsLabel = new JLabel("How many columns are there?");
        columnsLabel.setForeground(Color.white);
        columnsLabel.setBounds(10, 20, 300, 25);
        columnsLabel.setVisible(false);
        panel.add(columnsLabel);

        JTextField columnsText = new JTextField();
        columnsText.setForeground(Color.black);
        columnsText.setBounds(10, 50, 100, 25);
        columnsText.setVisible(false);
        panel.add(columnsText);

        JButton columnsSubmitButton = new JButton("Submit");
        columnsSubmitButton.setBackground(new Color(69,69,69));
        columnsSubmitButton.setForeground(new Color(255,255,255));
        columnsSubmitButton.setBounds(10, 80, 80, 25);
        columnsSubmitButton.setVisible(false);
        panel.add(columnsSubmitButton);

        JLabel extraLabel = new JLabel("How many extras are there?");
        extraLabel.setForeground(Color.white);
        extraLabel.setBounds(10, 20, 300, 25);
        extraLabel.setVisible(false);
        panel.add(extraLabel);

        JTextField extraText = new JTextField();
        extraText.setForeground(Color.black);
        extraText.setBounds(10, 50, 100, 25);
        extraText.setVisible(false);
        panel.add(extraText);

        JButton extraSubmitButton = new JButton("Submit");
        extraSubmitButton.setBackground(new Color(69,69,69));
        extraSubmitButton.setForeground(new Color(255,255,255));
        extraSubmitButton.setBounds(10, 80, 80, 25);
        extraSubmitButton.setVisible(false);
        panel.add(extraSubmitButton);

        JLabel gridLabel = new JLabel();
        gridLabel.setForeground(Color.white);
        gridLabel.setBounds(10, 85, 250, 250);
        gridLabel.setVisible(false);
        panel.add(gridLabel);

        JButton rerollButton = new JButton("Reroll?");
        rerollButton.setBackground(new Color(69,69,69));
        rerollButton.setForeground(new Color(255,255,255));
        rerollButton.setBounds(10, 50, 80, 25);
        rerollButton.setVisible(false);
        panel.add(rerollButton);
        
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(Color.red);
        resetButton.setForeground(Color.white);
        resetButton.setBounds(110, 50, 80, 25);
        resetButton.setVisible(false);
        panel.add(resetButton);

        rowsSubmitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String rowsUser = rowsText.getText();
                    if(!rowsUser.isEmpty() && isNumber(rowsUser)) {
                        rowsUserStr = Integer.parseInt(rowsUser);
                        rowsLabel.setVisible(false);
                        rowsText.setVisible(false);
                        rowsSubmitButton.setVisible(false);
                        columnsLabel.setVisible(true);
                        columnsText.setVisible(true);
                        columnsSubmitButton.setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(panel, "Not a valid number.");
                    }
                }
            });
        columnsSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String columnsUser = columnsText.getText();
                if(!columnsUser.isEmpty() && isNumber(columnsUser)) {
                    columnsUserStr = Integer.parseInt(columnsUser);
                    columnsLabel.setVisible(false);
                    columnsText.setVisible(false);
                    columnsSubmitButton.setVisible(false);
                    extraLabel.setVisible(true);
                    extraText.setVisible(true);
                    extraSubmitButton.setVisible(true);
                }else {
                        JOptionPane.showMessageDialog(panel, "Not a valid number.");
                    }
            }
        });

        extraSubmitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String extraUser = extraText.getText();
                    if ((!extraUser.isEmpty() && isNumber(extraUser)) || extraUser.equals("0")) {
                        extraUserStr = Integer.parseInt(extraUser);

                        extraLabel.setVisible(false);
                        extraText.setVisible(false);
                        extraSubmitButton.setVisible(false);

                        String grid = randomGridPlacement(columnsUserStr, rowsUserStr, extraUserStr).toString();
                        gridLabel.setText("<html>" + grid.replace("\n", "<br>") + "</html>");
                        gridLabel.setVisible(true);
                        rerollButton.setVisible(true);
                        resetButton.setVisible(true);
                        gridLabel.revalidate();
                        gridLabel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(panel, "Not a valid number.");
                    }
                }
            });
        rerollButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String grid = randomGridPlacement(columnsUserStr, rowsUserStr, extraUserStr).toString();
                    gridLabel.setText("<html>" + grid.replace("\n", "<br>") + "</html>");
                    gridLabel.revalidate();
                    gridLabel.repaint();
                }
            });
        

        resetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    rowsLabel.setVisible(true);
                    rowsText.setVisible(true);
                    rowsSubmitButton.setVisible(true);
                    columnsLabel.setVisible(false);
                    columnsText.setVisible(false);
                    columnsSubmitButton.setVisible(false);
                    extraLabel.setVisible(false);
                    extraText.setVisible(false);
                    extraSubmitButton.setVisible(false);
                    gridLabel.setVisible(false);
                    rerollButton.setVisible(false);
                    resetButton.setVisible(false);
                }
            });

    }

    public static Object randomGridPlacement(int columns, int rows, int add) {
        int threshold = ((rows * columns + add)/2);
        int random = RandomNumberGenerator.generate(0,threshold);
        boolean temp = true;
        ArrayList<String> grid = new ArrayList<>();
        for(int i = rows; i > 0; i--){
            for(int z = columns; z > 0; z--){
                random = RandomNumberGenerator.generate(0,threshold);
                if(random != threshold || !temp){
                    grid.add("H ");
                } else {
                    grid.add("A ");
                    temp = false;
                }
            }
            grid.add("\n");
        }
        for(int q = add; q > 0; q--){
            random = RandomNumberGenerator.generate(0,threshold);
            if(random != threshold || !temp){
                    grid.add("H ");
                } else {
                    grid.add("A ");
                    temp = false;
                }
        }
        if(temp){
            int randCol = RandomNumberGenerator.generate(1, columns);
            int randRow = RandomNumberGenerator.generate(1, rows);
            grid.add("\nA placed at (" + randCol + ", " + randRow + ") to ensure appearance.");
        }

        StringBuilder condensedGrid = new StringBuilder();
        for (String obj : grid) {
            condensedGrid.append(obj);
        }
        return condensedGrid;
    }
    
    public static boolean isNumber(String input) {
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
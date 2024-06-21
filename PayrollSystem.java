import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayrollSystem {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Payroll System");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");
        hourlyRateLabel.setBounds(50, 20, 100, 25);
        frame.add(hourlyRateLabel);

        JTextField hourlyRateField = new JTextField();
        hourlyRateField.setBounds(200, 20, 150, 25);
        frame.add(hourlyRateField);

        JLabel hoursWorkedLabel = new JLabel("Regular Hours Worked:");
        hoursWorkedLabel.setBounds(50, 60, 150, 25);
        frame.add(hoursWorkedLabel);

        JTextField hoursWorkedField = new JTextField();
        hoursWorkedField.setBounds(200, 60, 150, 25);
        frame.add(hoursWorkedField);

        JLabel overtimeHoursLabel = new JLabel("Overtime Hours Worked:");
        overtimeHoursLabel.setBounds(50, 100, 150, 25);
        frame.add(overtimeHoursLabel);

        JTextField overtimeHoursField = new JTextField();
        overtimeHoursField.setBounds(200, 100, 150, 25);
        frame.add(overtimeHoursField);

        JButton calculateButton = new JButton("Calculate Gross Pay");
        calculateButton.setBounds(150, 140, 150, 25);
        frame.add(calculateButton);

        JLabel resultLabel = new JLabel("Gross Pay: $0.00");
        resultLabel.setBounds(150, 180, 200, 25);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double hourlyRate = Double.parseDouble(hourlyRateField.getText());
                    double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
                    double overtimeHours = Double.parseDouble(overtimeHoursField.getText());
                    double regularPay = hourlyRate * hoursWorked;
                    double overtimePay = hourlyRate * 1.5 * overtimeHours;
                    double grossPay = regularPay + overtimePay;
                    resultLabel.setText(String.format("Gross Pay: $%.2f", grossPay));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
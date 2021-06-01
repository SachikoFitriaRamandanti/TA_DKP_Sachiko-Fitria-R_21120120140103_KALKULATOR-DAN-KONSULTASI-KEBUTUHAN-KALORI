import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormKalori {
    private JTextField tfUmur;
    private JTextField tfTb;
    private JTextField tfBb;
    private JButton hitungButton;
    private JButton hapusButton;
    private JButton keluarButton;
    private JLabel labelUmur;
    private JLabel labelTb;
    private JTextArea textKeterangan;
    private JComboBox<String> comboPilihan;
    private JLabel labelGender;
    private JLabel labelJudul;
    private JPanel panelKalori;
    private JLabel labelJk;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Kalori");
        frame.setContentPane(new FormKalori().panelKalori);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FormKalori() {
        comboPilihan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Gender = (String) comboPilihan.getSelectedItem();
                switch (Gender) {
                    case "Pilih Jenis Kelamin":
                        textKeterangan.setText("Anda belum memilih Jenis Kelamin.");
                        break;
                    case "Laki-laki":
                        textKeterangan.setText("");
                        break;
                    case "Perempuan":
                        textKeterangan.setText("");
                        break;
                }
            }
        });
        tfUmur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Umur = Integer.parseInt(tfUmur.getText());
                if (Umur < 0) {
                    tfUmur.setEditable(false);
                } else {
                    tfUmur.setEditable(true);
                }
            }
        });
        tfTb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double Tb;     //Tinggi Badan
                Tb = Double.parseDouble(tfTb.getText());
                if (Tb < 0) {
                    tfTb.setEditable(false);
                } else {
                    tfTb.setEditable(true);
                }
            }
        });
        tfBb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double Bb;   //beratbadan
                Bb = Double.parseDouble(tfBb.getText());
                if (Bb < 0) {
                    tfTb.setEditable(false);
                } else {
                    tfTb.setEditable(true);
                }
            }
        });
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfUmur.setText("");
                comboPilihan.setSelectedIndex(0);
                tfTb.setText("");
                tfBb.setText("");
                textKeterangan.setText("");
            }
        });
        keluarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data data = new Data();

                double jmkal;
                String gender;

                Double tb = data.getTb();
                Double bb = data.getBb();
                Integer umur = data.getUmur();

                tb = Double.parseDouble(tfTb.getText().toString());
                bb = Double.parseDouble(tfBb.getText().toString());
                umur = Integer.parseInt(tfUmur.getText().toString());

                gender = (String) comboPilihan.getSelectedItem();

                switch (gender) {
                    case "Laki-laki":
                        jmkal = 66 + (13.7 * bb) + (5 * tb) - (6.8 * umur);
                        textKeterangan.setText("Kalori yang dibutuhkan anda /hari : " + jmkal + " KKal" + "\nInfo!!!" +
                        "\nTubuh manusia membutuhkan kalori untuk bertahan hidup. Karena kalori bermanfaat" +
                        "\nuntuk menyiapkan energi bagi manusia. Tanpa energi, sel-sel dalam tubuh akan mati," +
                        "\njantung dan paru-paru akan berhenti, dan organ-organ tidak akan dapat menjalankan " +
                        "\nproses dasar yang diperlukan untuk hidup." +
                        "\n*Tips Memenuhi Kebutuhan Kalori*:" +
                        "\nBagi kalori menjadi kurang lebih 30% untuk makan pagi, 40-50% makan siang, " +
                        "\ndan 20-30% makan malam. Untuk mengetahui jumlah kalori dari makanan yang Anda konsumsi," +
                        "\nAnda dapat melihat buku patokan sebagai berikut:" +
                        "\n•1 gram karbohidrat (nasi, roti, ubi) ~ 4 Kalori" +
                        "\n•1 gram protein (telur, ikan, daging, kacang) ~ 4 Kalori" +
                        "\n•1 gram lemak (minyak atau lemak daging) ~ 9 Kalori");
                    case "Perempuan":
                        jmkal = 66 + (9.6 * bb) + (1.7 * tb) - (4.7 * umur);
                        textKeterangan.setText("Kalori yang dibutuhkan anda /hari : " + jmkal + " KKal" + "\nInfo!!!" +
                        "\nTubuh manusia membutuhkan kalori untuk bertahan hidup. Karena kalori bermanfaat" +
                        "\nuntuk menyiapkan energi bagi manusia. Tanpa energi, sel-sel dalam tubuh akan mati," +
                        "\njantung dan paru-paru akan berhenti, dan organ-organ tidak akan dapat menjalankan " +
                        "\nproses dasar yang diperlukan untuk hidup." +
                        "\n*Tips Memenuhi Kebutuhan Kalori*:" +
                        "\nBagi kalori menjadi kurang lebih 30% untuk makan pagi, 40-50% makan siang, " +
                        "\ndan 20-30% makan malam. Untuk mengetahui jumlah kalori dari makanan yang Anda konsumsi," +
                        "\nAnda dapat melihat buku patokan sebagai berikut:" +
                        "\n•1 gram karbohidrat (nasi, roti, ubi) ~ 4 Kalori" +
                        "\n•1 gram protein (telur, ikan, daging, kacang) ~ 4 Kalori" +
                        "\n•1 gram lemak (minyak atau lemak daging) ~ 9 Kalori");
                   }
               }
            });
        }
}
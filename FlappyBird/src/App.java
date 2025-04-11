// Saya Nuansa Bening Aura Jelita dengan NIM 2301410 mengerjakan Tugas Praktikum 6 dalam mata kuliah
// Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan
// seperti yang telah dispesifikasikan. Aamiin.

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // sudah ada di start form
//        // buat sebuah frame
//        JFrame frame = new JFrame("Flappy Bird");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(360, 640);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        // frame.setVisible(true);
//
//        // buat objek JPanel
//        FlappyBird flappyBird = new FlappyBird();
//        frame.add(flappyBird);
//        frame.pack();
//        flappyBird.requestFocus();
//        frame.setVisible(true);

        // tampilkan Start Menu terlebih dahulu
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StartForm menu  = new StartForm();
                menu.setVisible(true);
            }
        });
    }
}


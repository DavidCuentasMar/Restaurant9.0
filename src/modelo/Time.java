/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.General;

/**
 *
 * @author pc
 */
public class Time extends Thread {

    private General G;
    private int Seg;

    public Time(General G) {
        this.G = G;
        Seg = G.getSeg();
    }

    @Override
    public void run() {
        for (;;) {
            if (Seg != 10) {
                Seg = G.aumentSeg();
            } else {
                Seg = 0;
                G.resetSeg();
                G.parar();
                
            }
            try {
                sleep(999);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            if (!G.isContinuar()) {
                try {
                    synchronized (this) {
                        this.wait();
                    }
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }
}

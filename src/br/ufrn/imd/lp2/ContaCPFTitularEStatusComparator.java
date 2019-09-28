package br.ufrn.imd.lp2;

import java.util.Comparator;

public class ContaCPFTitularEStatusComparator implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria o1, ContaBancaria o2) {
        if (o1.getCPF().compareTo(o2.getCPF()) == 0) {
            if (o1.getAtivo() == o2.getAtivo()) {
                return 0;
            }
            if (o1.getAtivo() == false && o2.getAtivo() == true) {
                return 1;
            }
            return -1;
        }
        return o1.getCPF().compareTo(o2.getCPF()) ;
    }
}

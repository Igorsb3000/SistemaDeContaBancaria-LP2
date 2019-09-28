package br.ufrn.imd.lp2;

import java.util.Comparator;

public class ContaCPFComparator implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria o1, ContaBancaria o2) {
        return o1.getCPF().compareTo(o2.getCPF());
    }
}

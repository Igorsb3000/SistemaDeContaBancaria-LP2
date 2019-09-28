package br.ufrn.imd.lp2;

import java.util.Comparator;

public class ContaNomeECPFComparator implements Comparator<ContaBancaria> {
    @Override
    public int compare(ContaBancaria o1, ContaBancaria o2) {
        if(o1.getNome().compareTo(o2.getNome()) == 0){
            return o1.getCPF().compareTo(o2.getCPF()); //ordem crescente
        }
        return o1.getNome().compareTo(o2.getNome());
    }
}

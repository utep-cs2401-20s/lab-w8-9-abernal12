import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AminoAcidLLTester {

    @Test
    void codonCompare() {
        AminoAcidLL codonTest = AminoAcidLL.createFromRNASequence("GCUAGCGAAGCUAGA"); // used as the given Amino Acid list to compare
        AminoAcidLL result = AminoAcidLL.createFromRNASequence("GCUAGCGAAGCUAGA"); // the result of how the list should look like
        codonTest = AminoAcidLL.sort(codonTest);
        result = AminoAcidLL.sort(result);

        int testCodon = result.aminoAcidCompare(codonTest);
        int diffResult = 2;
        assertEquals(diffResult,testCodon);
    }

    @Test
    void aminoAcidCompare(){
        AminoAcidLL aminoAcidTest = AminoAcidLL.createFromRNASequence("GCUAGCGAAGCUAGA"); // used as the given Amino Acid list to compare
        AminoAcidLL result = AminoAcidLL.createFromRNASequence("GCUAGCGAAGCUAGA"); // the result of how the list should look like
        aminoAcidTest = AminoAcidLL.sort(aminoAcidTest);
        result = AminoAcidLL.sort(result);

        int testaminoAcid = result.aminoAcidCompare(aminoAcidTest);
        int diffResult = 2;
        assertEquals(diffResult,testaminoAcid);
    }

    @Test
    void aminoAcidList(){
        String aminoAcidList = "GAUAGG";
        AminoAcidLL result = AminoAcidLL.createFromRNASequence(aminoAcidList);
        char[] given = result.aminoAcidList();
        char[] expected = {};
    }

    @Test
    void aminoAcidCounts(){

    }

    @Test
    void isSorted(){

    }

    @Test
    void createFromRNASequence(){

    }

    @Test
    void sort(){

    }

    @Test
    void sort2(){

    }

    @Test
    void sort3(){
        AminoAcidLL aminoAcidTest = AminoAcidLL.createFromRNASequence("GCUAGCGAAGCUAGA"); // used as the given Amino Acid list to compare
        AminoAcidLL result = AminoAcidLL.createFromRNASequence("AAAAACCCGGGGGUU"); // the result of how the list should look like
        aminoAcidTest = AminoAcidLL.sort(aminoAcidTest);
        result = AminoAcidLL.sort(result);
    }

    @Test
    void aminoAcidList2(){

    }
}

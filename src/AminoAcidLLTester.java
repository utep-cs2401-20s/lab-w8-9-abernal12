import org.junit.Test;

import static org.junit.Assert.assertEquals;

class AminoAcidLLTester {

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
    void aminoAcid(){
        AminoAcidLL aminoAcidTest = AminoAcidLL.createFromRNASequence("GCUAGCGAAGCUAGA"); // used as the given Amino Acid list to compare
        AminoAcidLL result = AminoAcidLL.createFromRNASequence("GCUAGCGAAGCUAGA"); // the result of how the list should look like
        aminoAcidTest = AminoAcidLL.sort(aminoAcidTest);
        result = AminoAcidLL.sort(result);

        int testaminoAcid = result.aminoAcidCompare(aminoAcidTest);
        int diffResult = 2;
        assertEquals(diffResult,testaminoAcid);
    }
}

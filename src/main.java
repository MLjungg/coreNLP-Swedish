import java.io.IOException;

class main {

    public static void main(String[] args) {

        boolean runEngPipeline = false;
        boolean runSwePipeline = true;

        if (runEngPipeline) {
            String eng_text = "Bell, based in Los Angeles, makes and distributes electronic, computer and building products.";
            EnglishPipeLine.main(eng_text);
        }
        System.out.println("------------");
        if (runSwePipeline) {
            String swe_text = "Det är dåligt att vara kund på Handelsbanken";
            String gdpr_text = SwedishPipeLine.main(swe_text);
            System.out.println(gdpr_text);
        }
    }
}
class main {

    public static void main(String[] args) {

        boolean run_eng = false;
        boolean run_sv = true;

        if (run_eng) {
            String eng_text = "Bell, based in Los Angeles, makes and distributes electronic, computer and building products.";
            EnglishPipeLine.main(eng_text);
        }
        System.out.println("------------");
        if (run_sv) {
            String swe_text = "Erik och Mikael är sjuka i COVID. Det är tråkigt.";
            String gdpr_text = SwedishPipeLine.main(swe_text);
            System.out.println(gdpr_text);
        }
    }
}
package br.fenomeno.entity;

enum EnumTime{
   
	A("A"), B("B");

    EnumTime(String time){
        this.time = time;
    }

    private String time;

    public String getTime() {
        return time;
    }

}

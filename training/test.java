class main {
  public static void main(String[] args) {
    int tabint[] = new int[1];
	tabint[0] = 12;
    addinttotab myObj = new addinttotab();
	tabint = myObj.addInt(tabint, 12);
	tabint = myObj.addInt(tabint, 24);
	for (int i : tabint)
	{
		System.out.println(i);
  	}
  }
}

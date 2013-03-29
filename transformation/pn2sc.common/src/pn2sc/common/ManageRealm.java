package pn2sc.common;

public class ManageRealm {
	private static DefaultRealm realm = null;

	/**
	 * Creates a new default realm.
	 */
	public static void setUp() {
		if (realm == null)
			realm = new DefaultRealm();
	}

	/**
	 * Removes the default realm.
	 */
	public static void tearDown() {
		if (realm != null)
			realm.dispose();
	}

}

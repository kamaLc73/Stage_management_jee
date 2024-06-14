package com.jee.business;

public class Facade {
	
	private StageManagerImpl sm;
	private StagiaireManagerImpl sim;
	private InscriptionManagerImpl im;
	
	public Facade() {
		sm = new StageManagerImpl();
		sim = new StagiaireManagerImpl();
		im = new InscriptionManagerImpl();
	}

	public StageManagerImpl getSm() {
		return sm;
	}

	public void setSm(StageManagerImpl sm) {
		this.sm = sm;
	}

	public StagiaireManagerImpl getSim() {
		return sim;
	}

	public void setSim(StagiaireManagerImpl sim) {
		this.sim = sim;
	}

	public InscriptionManagerImpl getIm() {
		return im;
	}

	public void setIm(InscriptionManagerImpl im) {
		this.im = im;
	}
	
	
}

package pr2.a07;import java.beans.PropertyChangeEvent;import java.beans.PropertyChangeListener;import java.beans.PropertyChangeSupport;public class SmileyModel {	private final PropertyChangeSupport changer;	protected int x;	protected int y;	protected int r;	protected int eyeAngle;	protected int eyeSize;	protected boolean isSmiling;	public SmileyModel(int x, int y, int r, int eyeSize, int eyeAngle,  boolean isSmiling) {		changer = new PropertyChangeSupport(this);		this.x=x;		this.y=y;		this.r=r;		this.eyeAngle=eyeAngle;		this.eyeSize=eyeSize * r / 100;;		this.isSmiling=isSmiling;	}		public void addPropertyChangeListener(PropertyChangeListener I) {		changer.addPropertyChangeListener(I);	}		public void removePropertyChangeListener(PropertyChangeListener I) {		changer.removePropertyChangeListener(I);	}		public void firePropertyChange(PropertyChangeEvent e) {		changer.firePropertyChange(e);	}		public void setX(int x) {		int oldX = this.x;		this.x = x;		changer.firePropertyChange("MODEL_UPDATE", oldX, x);	}		public void setY(int y) {		int oldY = this.y;		this.y = y;		changer.firePropertyChange("MODEL_UPDATE", oldY, y);	}		public void setXY(int x, int y) {		this.x = x;		this.y = y;		changer.firePropertyChange("MODEL_UPDATE", null, null);	}		public void setR(int r) {		int oldR = this.r;		this.r = r;		changer.firePropertyChange("MODEL_UPDATE", oldR, r);	}		public void setEyeAngle(int eyeAngle) {		int oldEyeAngle = this.eyeAngle;		this.eyeAngle = eyeAngle;		changer.firePropertyChange("MODEL_UPDATE", oldEyeAngle, eyeAngle);	}		public void setEyeSize(int eyeSize) {		int oldEyeSize = this.eyeSize;		this.eyeSize = eyeSize;		changer.firePropertyChange("MODEL_UPDATE", oldEyeSize, eyeSize);	}		public void setSmile(boolean isSmiling) {		boolean oldIsSmiling = this.isSmiling;		this.isSmiling = isSmiling;		changer.firePropertyChange("MODEL_UPDATE", oldIsSmiling, isSmiling);	}		public int getX() {		return x;	}		public int getY() {		return y;	}		public int getRadius() {		return r;	}		public int getEyeAngle() {		return eyeAngle;	}		public int getEyeSize() {		return eyeSize;	}			public boolean getIsSmiling() {		return isSmiling;	}	}
package com.crud.crudjava;
import javax.xml.bind.*;
@XmlRootElement
public class Users {
		private String name;
		private int score;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		@Override
		public String toString() {
			return "Users [name=" + name + ", score=" + score + "]";
		}

		
}

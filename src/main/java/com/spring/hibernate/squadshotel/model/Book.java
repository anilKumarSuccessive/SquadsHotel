package com.spring.hibernate.squadshotel.model;

import java.time.LocalDate;
import java.util.List;

public class Book {
	
		  private LocalDate start;
		  private LocalDate end;
		  private List<User>  user;
		  private List<Rate>  rate;
		public LocalDate getStart() {
			return start;
		}
		public void setStart(LocalDate localDate) {
			this.start = localDate;
		}
		public LocalDate getEnd() {
			return end;
		}
		public void setEnd(LocalDate localDate) {
			this.end = localDate;
		}
		public List<User> getUser() {
			return user;
		}
		public void setUser(List<User> user) {
			this.user = user;
		}
		public List<Rate> getRate() {
			return rate;
		}
		public void setRate(List<Rate> rate) {
			this.rate = rate;
		}
		
		 
}

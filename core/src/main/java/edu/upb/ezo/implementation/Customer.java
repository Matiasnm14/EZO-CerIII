package edu.upb.ezo.implementation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.checkerframework.checker.units.qual.N;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Customer {
      private String name;
      private String lastname;
      private String document_number;
}

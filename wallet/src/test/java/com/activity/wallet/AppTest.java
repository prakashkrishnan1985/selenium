package com.activity.wallet;

import com.github.javafaker.Faker;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.lorem().sentence(30) );
	}
}

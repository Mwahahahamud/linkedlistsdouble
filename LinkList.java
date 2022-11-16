/*
 * Copyright 2022 Ben Philps <bp413@cam.ac.uk>, Andrew Rice <acr31@cam.ac.uk>, M. Haji
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.mh2169.linkedlists;

import java.util.NoSuchElementException;

public class LinkList {

  private static class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

    Node(int value) {
      this.value = value;
      this.next = null;
    }

    @Override
    public String toString() {
      if (next == null) {
        return String.valueOf(value);
      }
      return value + "," + next;
    }
  }

  private Node head;

  LinkList() {
    this.head = null;
  }


  public static LinkList create(int[] elements){
    LinkList newList = new LinkList();
    for (int i = 1; i < elements.length + 1; i++){
      newList.addFirst(elements[elements.length - i]);
    }
    return newList;
  }

  void addFirst(int element) {
    if (head == null) {
      head = new Node(element);
    } else {
      head = new Node(element, head);
    }
  }

  int removeFirst(){
    if (head == null){
      throw new NoSuchElementException();
    }
    else{
      int value = head.value;
      head = head.next;
      return value;
    }
  }



  int get(int n){
    Node nodes = this.head;
    if (n < 0) {throw new NoSuchElementException();}
    for (int i = 0; i < n; i++){
      if (nodes.next != null) {
        nodes = nodes.next;
      }
      else {throw new NoSuchElementException();}
    }
    return nodes.value;


  }

  int length(){
    Node nodes = this.head;
    int count = 0;
    while (nodes != null){
      nodes = nodes.next;
      count++;
    }
    return count;
  }

  @Override
  public String toString() {
    return String.format("[%s]", head == null ? "" : head.toString());
  }
}

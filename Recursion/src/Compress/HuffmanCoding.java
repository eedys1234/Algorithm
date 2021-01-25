package Compress;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class HuffmanCoding {

	public ArrayList<Run> runs = new ArrayList<>();
	public PriorityQueue<Run> heap = new PriorityQueue<Run>();
	public LinkedList<Run>[] map = new LinkedList[256];
	public Run theRoot = null;
		
	public void conpressFile(RandomAccessFile fin) {
		collectRun(fin);
		createHuffmaTree();
		assignCodeword(theRoot, 0, 0);
		storeRunintoArray(theRoot);		
	}
	
	public void collectRun(RandomAccessFile fin) {
		
		try {
			int i = 0;
			int ch = -1;
			int count = 0;
			byte previous = -1;

			while((ch = fin.read()) != -1) {
				byte symbol = (byte)ch;
				if(i==0) {
					previous = symbol;
				}
				count++;
				i++;
				if(symbol != previous) {
					Run run = new Run();
					run.length = count;
					run.symbol = symbol;
					run.frequency = 1;
					if(!runs.contains(run)) {
						runs.add(run);
					}
					else {
						Run contain_run = runs.stream().filter(value->value.equals(run)).findFirst().get();
						contain_run.frequency++;
					}
					count = 0;
				}
				previous = symbol;
			}
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createHuffmaTree() {
		
		for(int i=0;i<runs.size();i++) {
			heap.offer(runs.get(i));
		}
		
		while(heap.size() > 1) {
			Run run1 = heap.poll();
			Run run2 = heap.poll();
			
			Run conbineRun = new Run();
			conbineRun.frequency = run1.frequency + run2.frequency;
			conbineRun.left = run1;
			conbineRun.right = run2;
			
			heap.offer(conbineRun);
		}		
		theRoot = heap.poll();
	}
	
	
	public void printHuffmaTree(Run theRoot) {
		preOrderTraverse(theRoot, 0);
	}
	
	public void preOrderTraverse(Run node, int depth) {

		for(int i=0;i<depth;i++) {
			System.out.print(" ");			
		}
		
		if(node == null) {
			System.out.println("null");
		}
		else {
			System.out.println(node.toString());
			preOrderTraverse(node.left, depth+1);
			preOrderTraverse(node.right, depth+1);
		}
	}
	
	public void assignCodeword(Run node, int codeword, int codewordLength) {
		
		if(node.left == null && node.right == null) {
			node.codeword = codeword;
			node.codewordLength = codewordLength;
		}
		else {
			assignCodeword(node, (codeword << 1), codewordLength+1);
			assignCodeword(node, (codeword << 1)+1, codewordLength+1);			
		}
	}
	
	public void storeRunintoArray(Run node) {
		
		if(node.left == null && node.right == null) {
			int index = (int)node.symbol + 256;
			LinkedList<Run> list = map[index];
			
			if(list == null) {
				list = new LinkedList<Run>();
			}
			
			list.add(node);
		}
		else {
			storeRunintoArray(node.left);
			storeRunintoArray(node.right);
		}		
	}
	
	public Run findRun(byte symbol, int length) {

		int index = (int)symbol + 256;
		LinkedList<Run> list = map[index];		
		return list.stream().filter(run->run.length == length).findFirst().get();
	}
	
	public void fileOutInfo(RandomAccessFile fin, RandomAccessFile fout) throws IOException {
		fout.writeInt(runs.size());
		fout.writeLong(fin.getFilePointer());

		for(int i=0;i<runs.size();i++) {
			Run run = runs.get(i); 
			fout.writeByte(run.symbol);
			fout.writeInt(run.length);
			fout.writeInt(run.frequency);
		}
	}
	
	public void encode(RandomAccessFile fin, RandomAccessFile fout) throws IOException {
		
		int ch = -1;
		byte symbol = -1;
		byte previous = -1;
		int i=0;
		int cnt = 0;
		
		while((ch=fin.read())!=-1) {
			
			symbol = (byte)ch;			
			if(i==0) {
				previous = symbol;
			}
			
			cnt++;
			i++;
			
			if(symbol != previous) {				
				Run run = findRun(symbol, cnt);
				cnt = 0;
				fout.writeChars(Integer.toBinaryString(run.codeword));
			}
			
			previous = symbol;
		}
	}
	
	public void fileInInfo(RandomAccessFile fin, RandomAccessFile fout) throws IOException {
		/*
		fout.writeInt(runs.size());
		fout.writeLong(fin.getFilePointer());

		for(int i=0;i<runs.size();i++) {
			Run run = runs.get(i); 
			fout.writeByte(run.symbol);
			fout.writeInt(run.length);
			fout.writeInt(run.frequency);
		}
		*/
	}
	
	public void decode(RandomAccessFile fin, RandomAccessFile fout) throws IOException {

		int ch = -1;
		Run x = theRoot;
		
		while((ch=fin.read())!=-1) {
			
			if(ch == 0) {
				x = x.left;
			}
			else if(ch == 1) {
				x = x.right;
			}
			
			if(x.left == null && x.right == null) {
				
				for(int i=0;i<x.length;i++) {
					fout.write(x.symbol);					
				}
				x = theRoot;
			}
		}
	}
	
}
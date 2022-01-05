package Lab8AVLtree;

class AVLNode<K>{
	K key;
	AVLNode<K> left;	
	AVLNode<K> right;
	int bf;
	int height;
	
	public AVLNode(K key) {
		this(key ,null, null);
	}
	public AVLNode(K key, AVLNode<K> LEFT, AVLNode<K> right) {
		this.key=key;
		this.left = left;
		this.right  = right;
		
	}
}

public class MyAVLTree  <K extends Comparable <K>>{
	public AVLNode root;
	
	public MyAVLTree () {
		this.root=null;
	}
	public void insert(K x) {
		root = insert(x,root);
	}
	public void insert2(K x) {
		root = insert2(x,root);
	}
	public void remove(K x) {
		root = remove(x, root);
	}
	public void print() {
		print(root);
		System.out.print("\n");
	}
	public int height() {
		return height(root);
	}
	public int balf() {
		return balf(root);
	}
	public void mnodewtwo(K x) {
		mnodewtwo(x,root);
	}
	public AVLNode<K> insert(K x, AVLNode<K> tree) {
		if (tree==null) {
			tree =  new AVLNode<K>(x);
			return tree;
		}
//		left or right
		int result = x.compareTo(tree.key);
		if (result < 0 ) {
//			insert left
			tree.left =insert(x,tree.left);
			//check balance
			if (height(tree.left)-height(tree.right)==2) {
				// need to balance
				if (x.compareTo(tree.left.key)<0) {// ���xС��t�����������嵽t��������������LL����ת����
					tree = rr(tree);
				}else {
					tree = lrrotation(tree);//��֮���嵽��������������
				}
			}
		}else if (result>0) {
			tree.right = insert(x, tree.right);
			if (height(tree.right)-height(tree.left)==2) {
				if (x.compareTo(tree.right.key)>0) {
					tree=lr(tree);
				}else {
					tree=rlrotation(tree);
				}
			}
		}else {
			//have already exist
		}
		tree.height = Math.max(height(tree.left),height (tree.right))+1;
		return tree;
	}
	
	
	public AVLNode<K> insert2(K x, AVLNode<K> tree){
		AVLNode <K> t = tree;
		AVLNode <K> temp = tree;
		AVLNode <K> parent=tree;
		int count=-1;
		if (tree == null) {
			tree =  new AVLNode<K>(x);
			return tree;}
		
		while (t!=null ) {
			count++;
			int re = x.compareTo(t.key);
			if (re <0) { //insert left
				if (count==0) { 
					temp = t;
					t = t.left;}
				else {
					parent =temp;
					temp = t;
					t = t.left;}}
			else  if (re >0) { // insert right
				if (count==0) {
					parent = temp;
					temp = t;
					t = t.right;}
				else {
					parent =temp;
					temp=t;
					t = t.right;}}
			else 
				break;
		}
		t = temp;
		
		if (x.compareTo(t.key)<0) {
			t.left =new AVLNode<K>(x);
			if (ifb(parent)==2) {
				if (x.compareTo(tree.left.key)<0) {// ���xС��t�����������嵽t��������������LL����ת����
					tree = rr(tree);
				}else {
					tree = lrrotation(tree);
				}
			}
		}else if (x.compareTo(t.key)>0){
			t.right=new AVLNode<K>(x);
			if (ifb(parent)==-2) {
				if (x.compareTo(t.right.key)<0) 
					tree = lr (tree);
				else
					tree = rlrotation(tree);
			}
		}
		if (ifb(tree)==2) {
			if (ifb(tree.left)==1)
				tree = rr(tree);
			else
				tree = rr(tree);}
		else if (ifb(tree)==-2) {
			if (ifb(tree.right)==-1)
				tree = lr(tree);
			else
				tree = lr(tree);}

		return tree;
	}
	public int ifb(AVLNode<K> tree) {
		AVLNode<K> temp = tree;
		int lh = 0;
		int rh = 0;
		int re;
		while (temp.left!=null ) {
			temp = temp.left;
			lh++;
		}temp = tree;
		while (temp.right!=null ) {
			temp = temp.right;
			rh++;}
		
		re = lh -rh;
		return re;	
	}

	public AVLNode<K> balancechild (AVLNode<K> t){
		if (t.right==null) {//������Ϊ��
			if (height(t.left)-t.height==2) {
				AVLNode <K> temp = t.left;
				if (temp.left!=null) {
					t = rr(t);
				}else {
					t = lrrotation(t);
				}
			}
		}else {//ƽ���������� 
			AVLNode <K> temp = t.right;
			if (temp.left!=null) {
				if (height(temp.right)-height(temp.left)==2) {
					AVLNode <K> te = temp.right;
					if(te.right !=null) {
						temp = lr(temp);
					}else {
						temp = rlrotation(temp);
					}
				}
			}else {
				if (height(temp.right)-temp.height ==2) {
					AVLNode <K> te = temp.right;
					if(te.right !=null) {
						temp = lr(temp);
					}else {
						temp = rlrotation(temp);
					}
				}
			}
			if (height(t.left)-height(t.right)==2) {
				t = rr(t);
			}
		}
		return t;
	}
	
	private AVLNode<K> remove(K x, AVLNode<K> t) {
        if (t == null)
            return null;
        int compareResult = x.compareTo(t.key);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
            //����֮����֤�������Ƿ�ƽ��
            if (t.right != null) {        //��������Ϊ�գ���һ����ƽ��ģ���ʱ�������൱�Ը��ڵ�������Ϊ1, ����ֻ�����������ǿ����
                if (t.left == null) {     //��������ɾ����Ϊ�գ�����Ҫ�ж�������
                    if (height(t.right) - t.height == 2) {
                        AVLNode<K> k = t.right;
                        if (k.right != null) {        //���������ڣ��������������ת
                            t = lr(t);
                        } else {                      //���������������˫��ת
                            t = rlrotation(t);
                        }
                    }
                }
                if (t.left!=null){                  //�����ж����������ĸ߶Ȳ�
                    //����������Ҳ���ܲ�ƽ�⣬����ƽ�����������ٿ�������
                    AVLNode<K> k = t.left;
                    //ɾ������Ĭ��������������С�ڵ㲹ɾ���Ľڵ�
                    //k���������߶Ȳ�����k��������
                    if (k.right != null) {
                        if (height(k.left) - height(k.right) == 2) {
                            AVLNode<K> m = k.left;
                            if (m.left != null) {     //���������ڣ��������������ת
                                k = rr(k);
                            } else {                      //���������������˫��ת
                                k = lrrotation(k);
                            }
                        }
                    } else {
                        if (height(k.left) - k.height == 2) {
                            AVLNode<K> m = k.left;
                            if (m.left != null) {     //���������ڣ��������������ת
                                k = rr(k);
                            } else {                      //���������������˫��ת
                                k = lrrotation(k);
                            }
                        }
                    }
                    if (height(t.right) - height(t.left) == 2) {
                        //����������һ����ƽ��ģ�����ʧ��Ļ�����ת���Խ������
                        t = lr(t);
                    }
                }
            }
            //����֮�����heightֵ
            t.height = Math.max(height(t.left), height(t.right)) + 1;
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
            //������֤�����Ƿ�ƽ��
            if (t.left != null) {         //��������Ϊ�գ���һ����ƽ��ģ���ʱ�������൱�Ը��ڵ�������Ϊ1
                t = balancechild(t);
            }
            //����֮�����heightֵ
            t.height = Math.max(height(t.left), height(t.right)) + 1;
        } else if (t.left != null && t.right != null) {
            //Ĭ����������������С���ݴ���ýڵ�����ݲ��ݹ��ɾ���Ǹ��ڵ�
            AVLNode<K> min = t.right;
            while (min.left != null) {
                min = min.left;
            }
//            t.element = findMin(t.right).element;
            t.key = min.key;
            t.right = remove(t.key, t.right);
            t = balancechild(t);
            //����֮�����heightֵ
            t.height = Math.max(height(t.left), height(t.right)) + 1;
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }
	
	public AVLNode<K> rr (AVLNode<K> tree) {
		AVLNode newt = tree.left;
		tree.left = newt.right;
		newt.right = tree;
		tree.height = Math.max(height(tree.left), height(tree.right))+1;
		newt.height = Math.max(height(newt.left), height(newt.right))+1;
		return newt;
	}
	public AVLNode<K> lr (AVLNode<K> tree){
		AVLNode newt = tree.right;
		tree.right = newt.left;
		newt.left = tree;
		tree.height = Math.max(height(tree.left), height(tree.right))+1;
		newt.height = Math.max(height(newt.left), height(newt.right))+1;
		return newt;
	}
	public AVLNode<K> lrrotation (AVLNode<K> tree){
		tree.left = lr(tree.left);
		return rr(tree);
	}
	public AVLNode<K> rlrotation (AVLNode<K> tree){
		tree.right = rr(tree);
		return lr(tree);
	}
	public AVLNode mnodewtwo(K node,AVLNode<K> root) {
		if (root == null) {
	        return null;
	    }
	    int cmp = node.compareTo(root.key);
	    if (cmp < 0) {
	        root.left = mnodewtwo(node, root.left);
	        if (height(root.right) - height(root.left) == 2) {
	           AVLNode<K> pnode = root.right;
	            if (height(pnode.left) < height(pnode.right)) {
	                root = rr(root);
	            } else {
	                root = rlrotation(root);
	            }
	        }
	    } else if (cmp > 0) {
	        root.right = mnodewtwo(node, root.right);
	        if (height(root.left) - height(root.right) == 2) {
	            AVLNode<K> pnode = root.left;
	            if (height(pnode.left) < height(pnode.right)) {
	                root = lrrotation(root);
	            } else {
	                root = lr(root);
	            }
	        }
	    } else {
			if (root.left != null && root.right != null) {
			    if (height(root.left) > height(root.right)) {
			        /**
			         * �ҵ����������е����ڵ�
			         */
			        AVLNode<K> pnode = root.left;
			        while (pnode.right != null) {
			            pnode = pnode.right;
			        }
			        root.key = pnode.key;
			        root.left = mnodewtwo(pnode.key , root.left);
			    } else {
			        /**
			         * �ҵ��������е���С�ڵ�
			         */
			        AVLNode<K> pnode = root.right;
			        while (pnode.left != null) {
			            pnode = pnode.left;
			        }
			        root.key = pnode.key;
			        root.right = mnodewtwo(pnode.key , root.right);
			    }
			} else {
			    root = (root.left == null) ? root.right : root.left;
			}
	    }
		return root;
		
	}
	public int height(AVLNode<K> t) {
		//��� t=null �򷵻�-1�� ����t.height 
		return t == null ? -1 : t.height;
	}
	public int balf(AVLNode<K> t) {
		int a =height(t.left); 
		int b = height(t.right);
		return a-b;
	}
	
	public void print (AVLNode<K>  tree) {
		if(tree==null) {
			return;
		}
		System.out.print(tree.key+"("+balf(tree)+") ");
		print(tree.left);
		print(tree.right);
	}
	public void todo(String type,AVLNode<K> node, AVLNode<K> root) {
		switch (type){
		case "rr":
			rro(node);
			System.out.print("\n"+"After right single rotation: \n");
			preorder(root);
			return;
		case "lr":
			lro(node);
			System.out.print("\n"+"After left single rotation: \n");
			preorder(root);
			return;
		case "dr_r":
			dr_lr(node);
			System.out.print("\n"+"After right double rotation: \n");
			preorder(root);
			return;
		case "dr_l":
			dl_rl(node);
			System.out.print("\n"+"After left double rotation: \n");
			preorder(root);
			return;
		default:
			return;
		}
	}
	
	public void rro (AVLNode<K> node) {
		if (node == null) {
			return;
		}
		AVLNode temp = node.right;
		K temp_key = node.key;
		node.right  = node.left;
		node.key   = node.left.key;
		node.left = node.right.left;
		node.right.left = node.right.right;
		node.right.right  = temp;
		node.right.key  = temp_key;
		
	}
	public void lro(AVLNode<K> node)	{	
			AVLNode temp = node.left;
			K temp_key = node.key;
			node.left  = node.right;
			node.key   = node.right.key;
			node.right = node.left.right;
			node.left.right = node.left.left;
			node.left.left  = temp;
			node.left.key   = temp_key;
		}
	public void dr_lr(AVLNode<K> node) {
			AVLNode temp = node.right;
			K tempkey =  node.key;
			node.key = node.left.right.key;
			node.right = node.left.right;
			node.left.right = node.left.right.left;
			node.right.left = node.right.right;
			node.right.right = temp;
			node.right.key = tempkey;
		}
	public void dl_rl(AVLNode<K> node) {
			AVLNode temp = node.left;
			K tempkey =  node.key;
			node.key = node.right.left.key;
			node.left = node.right.left;
			node.right.left = node.right.left.right;
			node.right.right = node.left.left;
			node.left.left = temp;
			node.left.key = tempkey;
		}
	public void preorder(AVLNode t) {
			if (t != null)
	         {
				 System.out.print(t.key + " ");
				 preorder(t.left);
				 preorder(t.right);
				 
	         }
		}
	
}

function SLQueue(){
    this.head = null;
    this.tail = null;

    this.enQ = function(val){
        var node = new Node(val);
        if (!this.head){
            this.head = node;
            this.tail = node;
            return this;
        }
        this.tail.next = node;
        this.tail = node;
        return this;
    }

    this.deQ = function(){
        if (this.head){
            var node = this.head;
            this.head = this.head.next;
            if (!this.head){
                this.tail = null;
            }
            return node.value;
        }
        return null;
    }

    this.front = function(){
        if (this.head){
            return this.head.value;
        }
        return null;
    }

    this.contains = function(val){
        if (this.head){
            if (this.head.value == val || this.tail.value == val){
                return true;
            }
            var current = this.head.next;
            while (current){
                if (current.value == val){
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    this.isEmpty = function(){
        return !this.head;
    }

    this.size = function(){
        if (!this.isEmpty()){
            var size = 0;
            var current = this.head;
            while (current){
                size++;
                current = current.next;
            }
            return size;
        }
        return 0;
    }
}

function Node(val){
    this.value = val;
    this.next = null;
}

var mySLQ = new SLQueue();
console.log(mySLQ.isEmpty()); // true

mySLQ.enQ(5).enQ(10).enQ(15).enQ(20);

console.log(mySLQ.isEmpty()); // false
console.log(mySLQ.size()); // 4
console.log(mySLQ.contains(2)); // false
console.log(mySLQ.contains(20)); // true
console.log(mySLQ.deQ()); // 5
console.log(mySLQ.front()); // 10
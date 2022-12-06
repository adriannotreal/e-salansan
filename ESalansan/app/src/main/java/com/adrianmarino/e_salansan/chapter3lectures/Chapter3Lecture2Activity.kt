package com.adrianmarino.e_salansan.chapter3lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter3_lecture2.*

class Chapter3Lecture2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Operation on Data Structures"
        setContentView(R.layout.activity_chapter3_lecture2)

        Chapter3Lesson2Content1.text = "Design of an efficient data structures must take operations to be performed on the data structures into account. " +
                "The most commonly used operations on data structures are broadly categorized into following types:\n\n" +
                "1. Create - The create operation results in reserving memory for program elements. This can be done by a declaration statement."

        DataStructureOperationCreate.setText("//This piece of code is in C++\n\nint array[5] = {1, 2, 3, 4, 5};\n//declares an array data structure")

        Chapter3Lesson2Content1B.text = "2. Destroy - Destroy operation destroys the memory space allocated for a specific data structure."

        DataStructureOperationDestroy.setText("//This piece of code is in C++\n\ndelete[] array;\n//deletes the memory allocation of an array")

        Chapter3Lesson2Content2.text = "3. Selection - Selection deals with accessing a particular data within a data structure."

        DataStructureOperationSelection.setText("//This piece of code is in C++\n\ncout<<array[0];\n//access a selected element in an array and prints it")

        Chapter3Lesson2Content3.text = "4. Updating - It refers to modifying the data in the data structure."

        DataStructureOperationUpdate.setText("//This piece of code is in C++\n\narray[0] = 9;\n//updates a selected element in an array")

        Chapter3Lesson2Content4.text = "5. Searching - It finds the presence of the desired item in the list of data items. It may also find the locations of all elements that satisfy the condition."

        DataStructureOperationSearching.setText("// C++ code to linearly search x in arr[]. If x\n" +
                "// is present then return its location, otherwise\n" +
                "// return -1\n" +
                " \n" +
                "#include <iostream>\n" +
                "using namespace std;\n" +
                " \n" +
                "int search(int arr[], int n, int x)\n" +
                "{\n" +
                "    int i;\n" +
                "    for (i = 0; i < n; i++)\n" +
                "        if (arr[i] == x)\n" +
                "            return i;\n" +
                "    return -1;\n" +
                "}\n" +
                " \n" +
                "// Driver code\n" +
                "int main(void)\n" +
                "{\n" +
                "    int arr[] = { 2, 3, 4, 10, 40 };\n" +
                "    int x = 10;\n" +
                "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
                "   \n" +
                "    // Function call\n" +
                "    int result = search(arr, n, x);\n" +
                "    (result == -1)\n" +
                "        ? cout << \"Element is not present in array\"\n" +
                "        : cout << \"Element is present at index \" << result;\n" +
                "    return 0;\n" +
                "}")

        Chapter3Lesson2Content5.text = "6. Sorting - It is the process of arranging all data items in a data structure in a particular order."

        DataStructureOperationSorting.setText("// C++ program for implementation of Bubble sort \n" +
                "#include <bits/stdc++.h>\n" +
                "using namespace std;\n" +
                "  \n" +
                "void swap(int *xp, int *yp) \n" +
                "{ \n" +
                "    int temp = *xp; \n" +
                "    *xp = *yp; \n" +
                "    *yp = temp; \n" +
                "} \n" +
                "  \n" +
                "// A function to implement bubble sort \n" +
                "void bubbleSort(int arr[], int n) \n" +
                "{ \n" +
                "    int i, j; \n" +
                "    for (i = 0; i < n-1; i++)     \n" +
                "      \n" +
                "    // Last i elements are already in place \n" +
                "    for (j = 0; j < n-i-1; j++) \n" +
                "        if (arr[j] > arr[j+1]) \n" +
                "            swap(&arr[j], &arr[j+1]); \n" +
                "} \n" +
                "  \n" +
                "/* Function to print an array */\n" +
                "void printArray(int arr[], int size) \n" +
                "{ \n" +
                "    int i; \n" +
                "    for (i = 0; i < size; i++) \n" +
                "        cout << arr[i] << \" \"; \n" +
                "    cout << endl; \n" +
                "} \n" +
                "  \n" +
                "// Driver code \n" +
                "int main() \n" +
                "{ \n" +
                "    int arr[] = {64, 34, 25, 12, 22, 11, 90}; \n" +
                "    int n = sizeof(arr)/sizeof(arr[0]); \n" +
                "    bubbleSort(arr, n); \n" +
                "    cout<<\"Sorted array: \\n\"; \n" +
                "    printArray(arr, n); \n" +
                "    return 0; \n" +
                "} ")

        Chapter3Lesson2Content6.text = "7. Merging - It is the process of combining the data items of two different sorted list into a single sorted list."

        DataStructureOperationMerging.setText("// C++ Program to Merge Two Arrays\n" +
                "\n" +
                "#include<iostream>\n" +
                "using namespace std;\n" +
                "int main()\n" +
                "{\n" +
                "    int arrOne[50], arrTwo[50], arrMerge[100];\n" +
                "\tint sizeOne, sizeTwo, i, k;\n" +
                "    cout<<\"Enter the Size for First Array: \";\n" +
                "    cin>>sizeOne;\n" +
                "    cout<<\"Enter \"<<sizeOne<<\" Elements for First Array: \";\n" +
                "    for(i=0; i<sizeOne; i++)\n" +
                "    {\n" +
                "        cin>>arrOne[i];\n" +
                "        arrMerge[i] = arrOne[i];\n" +
                "    }\n" +
                "    k = i;\n" +
                "    cout<<\"\\nEnter the Size for Second Array: \";\n" +
                "    cin>>sizeTwo;\n" +
                "    cout<<\"Enter \"<<sizeTwo<<\" Elements for Second Array: \";\n" +
                "    for(i=0; i<sizeTwo; i++)\n" +
                "    {\n" +
                "        cin>>arrTwo[i];\n" +
                "        arrMerge[k] = arrTwo[i];\n" +
                "        k++;\n" +
                "    }\n" +
                "    cout<<\"\\nThe New Array (Merged Array):\\n\";\n" +
                "    for(i=0; i<k; i++)\n" +
                "        cout<<arrMerge[i]<<\" \";\n" +
                "    cout<<endl;\n" +
                "    return 0;\n" +
                "}")

        Chapter3Lesson2Content7.text = "8. Splitting - It is the process of partitioning single list from multiple list."

        DataStructureOperationSplitting.setText("// C++ Program to Split an Array into Two\n" +
                "\n" +
                "#include<iostream>\n" +
                "using namespace std;\n" +
                "int main()\n" +
                "{\n" +
                "    int a[4] = {1, 2, 3, 4};\n" +
                "    int b[2] = {};\n" +
                "    int c[2] = {};\n" +
                "    int ctrB = 0;\n" +
                "    int ctrC = 0;\n\n" +
                "    for(i=0; i<4; i++)\n" +
                "    {\n" +
                "        if((i+2)%2==0){\n" +
                "           b[ctrB] = a[i];\n" +
                "           ctrB++;\n" +
                "        }else{\n" +
                "           c[ctrC] = a[i];\n" +
                "           ctrC++;\n" +
                "        }\n"+
                "     }\n\n"+
                "    return 0;\n" +
                "}")

        Chapter3Lesson2Content8.text = "9. Traversing - It is the process of visiting each and every node of a list in a systematic manner."

        DataStructureOperationTraversing.setText("// C++ Program on Traversing an Array\n" +
                "\n" +
                "#include<iostream>\n" +
                "using namespace std;\n" +
                "int main()\n" +
                "{\n" +
                "    int a[4] = {1, 2, 3, 4};\n" +
                "    for(i=0; i<4; i++)\n" +
                "    {\n" +
                "        cout<<a[i];\n"+
                "    }\n\n"+
                "    return 0;\n" +
                "}")
    }
}
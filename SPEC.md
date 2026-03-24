# MyBookshelf - Android eBook Reader Application

## 1. Project Overview

**Project Name:** MyBookshelf
**Type:** Native Android Application

**Core Functionality:** A feature-rich eBook reader application that supports multiple eBook formats (PDF, EPUB, TXT, MOBI, AZW3) with a bookshelf-style UI, allowing users to organize, read, annotate, and translate their eBook collection.

## 2. Technology Stack & Choices

### Framework & Language
- **Language:** Kotlin 1.9.x
- **Min SDK:** 26 (Android 8.0)
- **Target SDK:** 34 (Android 14)
- **Compile SDK:** 34

### Architecture
- **Pattern:** MVVM with Clean Architecture
- **Layers:** UI (Compose) → Domain (Use Cases) → Data (Repository)

### Key Libraries

| Category | Library | Purpose |
|----------|---------|---------|
| UI | Jetpack Compose + Material 3 | Modern declarative UI |
| Navigation | Compose Navigation | Screen routing |
| DI | Hilt | Dependency injection |
| Database | Room | Local SQLite storage |
| Async | Kotlin Coroutines + Flow | Async operations |
| eBook Parsing | PDF: PdfRenderer/AndroidPdfViewer<br>EPUB: Epublib<br>TXT: Built-in<br>MOBI/AZW3: KePub (or KindleUnpack) | eBook format support |
| Image Loading | Coil | Book cover thumbnails |
| Network | Retrofit + OkHttp | Translation API |
| JSON | Gson | JSON parsing |

### State Management
- ViewModel with StateFlow for UI state
- Repository pattern for data access

## 3. Feature List

### Core Features
1. **Bookshelf Management**
   - Import books from device storage
   - Display books in grid/list view with covers
   - Delete books from library

2. **Book Categories & Tags**
   - Create custom categories (e.g., "Favorites", "Reading", "Completed")
   - Add multiple tags to books
   - Filter/search by category or tag

3. **Book Reader**
   - Open and read books in supported formats
   - Remember reading position (auto-save progress)
   - Navigate pages/chapters

4. **Bookmarks**
   - Add bookmarks at current position
   - View and navigate to bookmarks
   - Delete bookmarks

5. **Notes**
   - Add notes to specific locations
   - View all notes for a book
   - Edit and delete notes

6. **Text Translation**
   - Select text and translate via Google Translate API
   - Copy translated text to clipboard

7. **Text Selection & Clipboard**
   - Long-press to select text
   - Copy text to clipboard

8. **Search**
   - Search books by title, author, tags, or category

## 4. UI/UX Design Direction

### Visual Style
- **Design System:** Material Design 3 (Material You)
- **Theme:** Clean, minimalist with warm, book-friendly colors
- **Color Scheme:**
  - Primary: Deep blue (#1565C0)
  - Secondary: Warm amber (#FFA000)
  - Surface: Light cream (#FFF8E1) for light mode
  - Dark mode support with muted colors

### Layout Approach
- **Navigation:** Bottom navigation bar with 3 main sections:
  - Library (bookshelf)
  - Categories
  - Settings
- **Bookshelf:** Grid view of book covers with title
- **Reader:** Full-screen reading mode with floating action buttons for tools

### Key Screens
1. **Library Screen** - Grid of books with search bar
2. **Book Detail Screen** - Book info, categories, tags, bookmarks, notes
3. **Reader Screen** - Full-screen eBook reader
4. **Categories Screen** - List of categories with book counts
5. **Add/Edit Category Dialog**
6. **Settings Screen** - Theme, translation settings

## 5. Database Schema

### Tables
- **books:** id, title, author, file_path, cover_path, format, date_added, last_read, reading_position
- **categories:** id, name, color
- **book_categories:** book_id, category_id
- **tags:** id, name
- **book_tags:** book_id, tag_id
- **bookmarks:** id, book_id, position, title, date_created
- **notes:** id, book_id, position, content, date_created, date_modified

## 6. API Integration

### Translation
- **Google Translate API** (free tier or paid)
- Endpoint: `https://translation.googleapis.com/language/translate/v2`
- Method: POST with text and target language

## 7. Permissions Required
- `READ_EXTERNAL_STORAGE` (for importing books)
- `INTERNET` (for translation API)

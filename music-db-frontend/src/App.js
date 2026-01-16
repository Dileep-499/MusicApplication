import React, { useState, useEffect, useCallback } from 'react';
import api from './api';
import DataTable from './DataTable';

function App() {
    const [view, setView] = useState('artists');
    const [data, setData] = useState([]);
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    const [sort, setSort] = useState({ key: 'id', direction: 'asc' });
    
    // Filtering states
    const [selectedArtistId, setSelectedArtistId] = useState('');

    const fetchData = useCallback(async () => {
        try {
            let endpoint = `/${view}`;
            let params = {
                page: page,
                size: 10,
                sort: `${sort.key},${sort.direction}`
            };

            // Requirement: Support filtering by artist_id for Albums and Songs 
            if (selectedArtistId) {
                if (view === 'albums') params.artist_id = selectedArtistId;
                if (view === 'songs') params['album.artist_id'] = selectedArtistId;
            }

            const response = await api.get(endpoint, { params });
            setData(response.data.content);
            setTotalPages(response.data.totalPages);
        } catch (error) {
            console.error("Error fetching data:", error);
        }
    }, [view, page, sort, selectedArtistId]);

    useEffect(() => { fetchData(); }, [fetchData]);

    const handleSort = (key) => {
        setSort(prev => ({
            key,
            direction: prev.key === key && prev.direction === 'asc' ? 'desc' : 'asc'
        }));
    };

    const columns = {
        artists: [{ key: 'id', label: 'ID' }, { key: 'name', label: 'Name' }],
        albums: [{ key: 'id', label: 'ID' }, { key: 'name', label: 'Album Title' }, { key: 'yearReleased', label: 'Year' }],
        songs: [{ key: 'id', label: 'ID' }, { key: 'track', label: 'Track #' }, { key: 'name', label: 'Song Title' }]
    };

    const resetView = (newView) => {
        setView(newView);
        setPage(0);
        setSelectedArtistId(''); // Reset filters when changing views
    };

    return (
        <div style={{ padding: '20px', fontFamily: 'Arial' }}>
            <h1>Music Database</h1>
            
            <nav style={{ marginBottom: '20px' }}>
                <button onClick={() => resetView('artists')}>Artists</button>
                <button onClick={() => resetView('albums')}>Albums</button>
                <button onClick={() => resetView('songs')}>Songs</button>
            </nav>

            {/* Filter UI for Albums and Songs */}
            {(view === 'albums' || view === 'songs') && (
                <div style={{ marginBottom: '15px' }}>
                    <label>Filter by Artist ID: </label>
                    <input 
                        type="number" 
                        value={selectedArtistId} 
                        onChange={(e) => { setSelectedArtistId(e.target.value); setPage(0); }}
                        placeholder="Enter Artist ID"
                    />
                </div>
            )}

            <h2>{view.toUpperCase()} {selectedArtistId && `(Filtered by Artist ${selectedArtistId})`}</h2>
            
            <DataTable 
                data={data} 
                columns={columns[view]} 
                page={page} 
                totalPages={totalPages} 
                onPageChange={setPage} 
                onSort={handleSort}
                sortConfig={sort}
            />
        </div>
    );
}

export default App;